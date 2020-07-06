package gaurav.leetcode.may.week2;

public class Trie {

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (curr.get(c) != null) {
                curr = curr.get(c);
            } else {
                curr = curr.add(c);
            }
        }
        curr.wordEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.get(c) == null) {
                return false;
            }
            curr = curr.get(c);
        }

        return curr.wordEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.get(c) == null) {
                return false;
            }
            curr = curr.get(c);
        }

        return true;
    }

    static class TrieNode {
        private TrieNode[] arr;
        private boolean wordEnd;

        public TrieNode() {
            arr = new TrieNode[26];
        }

        public TrieNode add(char c) {
            arr[c - 'a'] = new TrieNode();
            return arr[c - 'a'];
        }

        public TrieNode get(char c) {
            return arr[c - 'a'];
        }
    }
}
