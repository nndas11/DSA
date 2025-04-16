package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("hallo");
        trie.insert("hello world");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("batman");

        System.out.println(trie.searchWord("car"));
        System.out.println(trie.searchWord("bat"));
        System.out.println(trie.prefixMatch("bat"));
    }
}
