package com.codesignal.cloudstorage;

import java.util.*;

class CloudStorageImpl implements CloudStorage {
    private final Map<String, Integer> files;              // fileName -> size
    private final Map<String, String>  fileOwner;          // fileName -> owner
    private final Map<String, Integer> userCapacity;       // userId -> capacity
    private final Map<String, Integer> userUsed;           // userId -> bytes used
    private final Map<String, Set<String>> userFiles;      // userId -> owned file names
    private final Map<String, Map<String, Integer>> userBackups; // userId -> backup of files

    public CloudStorageImpl() {
        files = new HashMap<>();
        fileOwner = new HashMap<>();
        userCapacity = new HashMap<>();
        userUsed = new HashMap<>();
        userFiles = new HashMap<>();
        userBackups = new HashMap<>();

        // Admin user: unlimited capacity
        userCapacity.put("admin", Integer.MAX_VALUE);
        userUsed.put("admin", 0);
        userFiles.put("admin", new HashSet<>());
    }

    // ---------- Level 1 ----------
    @Override
    public boolean addFile(String name, int size) {
        if (files.containsKey(name)) return false;
        files.put(name, size);
        fileOwner.put(name, "admin");
        userFiles.get("admin").add(name);
        userUsed.put("admin", userUsed.get("admin") + size);
        return true;
    }

    @Override
    public Optional<Integer> getFileSize(String name) {
        return files.containsKey(name) ? Optional.of(files.get(name)) : Optional.empty();
    }

    @Override
    public Optional<Integer> deleteFile(String name) {
        if (!files.containsKey(name)) return Optional.empty();
        int size = files.remove(name);
        String owner = fileOwner.remove(name);
        if (owner != null) {
            Set<String> set = userFiles.get(owner);
            if (set != null) set.remove(name);
            Integer used = userUsed.get(owner);
            if (used != null) userUsed.put(owner, used - size);
        }
        return Optional.of(size);
    }

    // ---------- Level 2 ----------
    @Override
    public List<String> getNLargest(String prefix, int n) {
        if (n <= 0) return Collections.emptyList();
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> e : files.entrySet()) {
            if (e.getKey().startsWith(prefix)) list.add(e);
        }
        list.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(n, list.size()); i++) {
            Map.Entry<String, Integer> e = list.get(i);
            result.add(e.getKey() + "(" + e.getValue() + ")");
        }
        return result;
    }

    // ---------- Level 3 ----------
    @Override
    public boolean addUser(String userId, int capacity) {
        if (userCapacity.containsKey(userId)) return false;
        userCapacity.put(userId, capacity);
        userUsed.put(userId, 0);
        userFiles.put(userId, new HashSet<>());
        return true;
    }

    @Override
    public Optional<Integer> addFileBy(String userId, String name, int size) {
        if (!userCapacity.containsKey(userId)) return Optional.empty();
        if (files.containsKey(name)) return Optional.empty();

        int cap = userCapacity.get(userId);
        int used = userUsed.get(userId);
        if (!"admin".equals(userId) && used + size > cap) return Optional.empty();

        files.put(name, size);
        fileOwner.put(name, userId);
        userFiles.get(userId).add(name);
        userUsed.put(userId, used + size);
        int remaining = "admin".equals(userId) ? Integer.MAX_VALUE : (cap - (used + size));
        return Optional.of(remaining);
    }

    @Override
    public Optional<Integer> mergeUser(String userId1, String userId2) {
        if (!userCapacity.containsKey(userId1) || !userCapacity.containsKey(userId2)) return Optional.empty();
        if (userId1.equals(userId2)) return Optional.empty();

        for (String f : userFiles.get(userId2)) {
            fileOwner.put(f, userId1);
        }
        userFiles.get(userId1).addAll(userFiles.get(userId2));

        int newUsed = userUsed.get(userId1) + userUsed.get(userId2);
        int newCap  = userCapacity.get(userId1) + userCapacity.get(userId2);
        userUsed.put(userId1, newUsed);
        userCapacity.put(userId1, newCap);

        // Delete user2 and its backup
        userFiles.remove(userId2);
        userUsed.remove(userId2);
        userCapacity.remove(userId2);
        userBackups.remove(userId2);

        return Optional.of(newCap - newUsed);
    }

    // ---------- Level 4 ----------
    @Override
    public Optional<Integer> backupUser(String userId) {
        if (!userCapacity.containsKey(userId)) return Optional.empty();

        Map<String, Integer> backup = new HashMap<>();
        for (String f : userFiles.get(userId)) {
            backup.put(f, files.get(f));
        }
        userBackups.put(userId, backup);
        return Optional.of(backup.size());
    }

    @Override
    public Optional<Integer> restoreUser(String userId) {
        if (!userCapacity.containsKey(userId)) return Optional.empty();

        Map<String, Integer> backup = userBackups.get(userId);

        // Delete all current files owned by user
        for (String f : new ArrayList<>(userFiles.get(userId))) {
            deleteFile(f);
        }

        if (backup == null) {
            // No backup existed → all files deleted
            return Optional.of(0);
        }

        int restored = 0;
        for (Map.Entry<String, Integer> e : backup.entrySet()) {
            String name = e.getKey();
            int size = e.getValue();
            if (!files.containsKey(name)) {
                // restore file
                files.put(name, size);
                fileOwner.put(name, userId);
                userFiles.get(userId).add(name);
                userUsed.put(userId, userUsed.get(userId) + size);
                restored++;
            }
        }
        return Optional.of(restored);
    }
}
