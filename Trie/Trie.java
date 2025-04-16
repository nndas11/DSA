package Trie;

//  A Trie (pronounced try) is a tree-like data structure used to efficiently store and retrieve strings,
//  especially useful for prefix-based operations like autocomplete, dictionary lookups, or spell-checking.
//  Also called Prefix Tree.
//  It supports operations like insertion, search, and prefix search in O(L) time, where L is the length of the word.
//  It uses extra space, but it's highly efficient for operations that involve a lot of string searches, especially when dealing with prefixes.

//  Each node represents a character of a word.
//  A path from the root to a node represents a prefix.
//  The end of a word is marked with a special end-of-word flag.


//  More flexible than an array (TrieNode[26]) — works for any character, not just lowercase English.
//  Especially useful for Unicode (emojis, non-English languages, etc.)
//  Memory-efficient when characters are sparse.


import java.util.HashMap;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isEndOfWord = true;
    }

    // Search if the word exists in the trie
    public boolean searchWord(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.get(ch);
            if(node == null)
                return false;
        }
        return node.isEndOfWord;
    }

    // Check if there's any word in the trie that starts with the given prefix
    public boolean prefixMatch(String prefix){
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            node = node.children.get(ch);
            if(node == null)
                return false;
        }
        return true;
    }

    // Delete a word from the trie
    // To delete a word, you need to remove nodes that are part of the word and ensure that the nodes are removed only if they are not part of any other word.
    // This is a bit tricky and requires backtracking.
    public void delete(String word) {
        System.out.println("TODO");
    }
}


