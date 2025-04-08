package utils;

//  Auto-Boxing & Unboxing in Java -> Feature in JAVA.
//  Auto-boxing = converting a primitive (like int) to its wrapper class (Integer)
//  Auto-unboxing = converting a wrapper (Integer) to its primitive (int)


import java.util.*;

public class AutoUnboxing {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequentElements(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequentElements(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Integer key: map.keySet()){
            buckets[map.get(key)].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i=buckets.length -1;i>=0;i--){

//            Java sees that:
//            buckets[i] is a List<Integer> (object)
//            You're looping with int (primitive)
//            So Java automatically unboxes each Integer to an int for you.

            for(int num: buckets[i]){
                ans[index++] = num;
                if(index == k)
                    return ans;
            }
        }
        return ans;
    }
}
