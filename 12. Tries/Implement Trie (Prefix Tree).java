/**
 * Implement Trie (Prefix Tree)
 * 
 * Example:
 * Input: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"], [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output: [null, null, true, false, true, null, true]
 */

class TrieNode {
    TrieNode[] children;  // Array to hold children nodes, one for each letter ('a' to 'z')
    boolean isWord;       // Flag to check if the node is the end of a valid word

    public TrieNode() {
        children = new TrieNode[26];  // Initialize children array for 26 letters
        isWord = false;  // Initially, it's not the end of a word
    }
}

class Trie {
    private TrieNode root;  // Root node of the Trie

    public Trie() {
        root = new TrieNode();  // Initialize the Trie with an empty root node
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;  // Start at the root
        for (char c : word.toCharArray()) {  // Traverse each character of the word
            int idx = c - 'a';  // Find the index (0-25) of the character
            if (node.children[idx] == null) {  // If the child node doesn't exist
                node.children[idx] = new TrieNode();  // Create a new TrieNode for that character
            }
            node = node.children[idx];  // Move to the next node
        }
        node.isWord = true;  // Mark the end of the word
    }

    // Search if the word exists in the Trie
    public boolean search(String word) {
        TrieNode node = root;  // Start at the root
        for (char c : word.toCharArray()) {  // Traverse each character of the word
            int idx = c - 'a';  // Find the index (0-25) of the character
            if (node.children[idx] == null) {  // If no child node exists for the character
                return false;  // Word doesn't exist in the Trie
            }
            node = node.children[idx];  // Move to the next node
        }
        return node.isWord;  // Return true if it's the end of a word, otherwise false
    }

    // Check if there is any word that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;  // Start at the root
        for (char c : prefix.toCharArray()) {  // Traverse each character of the prefix
            int idx = c - 'a';  // Find the index (0-25) of the character
            if (node.children[idx] == null) {  // If no child node exists for the character
                return false;  // No word starts with the given prefix
            }
            node = node.children[idx];  // Move to the next node
        }
        return true;  // If we can traverse all characters of the prefix, return true
    }
}
