/**
 * Design and implement a data structure that supports the following operations:
 * addWord(word: str) -> None: Inserts a word into the data structure.
 * search(word: str) -> boolean: Returns true if a word exists in the data structure and false if not. The word may contain wildcards (.) that can represent any letter.
 * 
 * Input: ["WordDictionary","addWord","addWord","addWord","search","search","search","search"], [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output: [null,null,null,null,false,true,true,true]
 */

class TrieNode {
    TrieNode[] children;  // Array to hold children nodes (one for each letter)
    boolean isWord;       // Flag to mark the end of a valid word

    public TrieNode() {
        children = new TrieNode[26];  // Initialize children array for 26 letters
        isWord = false;  // Initially, it's not the end of a word
    }
}

class WordDictionary {
    private TrieNode root;  // Root node of the Trie

    public WordDictionary() {
        root = new TrieNode();  // Initialize the WordDictionary with an empty root node
    }

    // Method to add a word to the data structure
    public void addWord(String word) {
        TrieNode node = root;  // Start at the root node
        for (char c : word.toCharArray()) {  // Traverse each character in the word
            int idx = c - 'a';  // Find the index (0-25) corresponding to the character
            if (node.children[idx] == null) {  // If the node doesn't exist, create it
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];  // Move to the next node
        }
        node.isWord = true;  // Mark the end of the word
    }

    // Method to search for a word with potential wildcards (.)
    public boolean search(String word) {
        return searchHelper(word, 0, root);  // Start the recursive search from the root node
    }

    // Helper method to perform the search with wildcards
    private boolean searchHelper(String word, int idx, TrieNode node) {
        if (idx == word.length()) {  // If we've reached the end of the word
            return node.isWord;  // Return true if it's the end of a valid word
        }

        char c = word.charAt(idx);  // Get the current character in the word

        if (c == '.') {  // If the character is a wildcard
            // Try all possible child nodes (each letter from 'a' to 'z')
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, idx + 1, child)) {  // Recurse for each valid child
                    return true;
                }
            }
        } else {
            int childIdx = c - 'a';  // Find the index (0-25) corresponding to the character
            if (node.children[childIdx] == null) {  // If no child node exists for the character
                return false;  // Return false as the word doesn't match
            }
            return searchHelper(word, idx + 1, node.children[childIdx]);  // Recurse for the next character
        }
        return false;  // Return false if no matches were found
    }
}
