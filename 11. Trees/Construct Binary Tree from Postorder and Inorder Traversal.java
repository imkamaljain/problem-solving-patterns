/**
 * Given two integer arrays postorder and inorder, where postorder is the postorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * 
 * Example:
 * Input: postorder = [9,15,7,20,3], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */

class Solution {
    // Map to store the index of each value in the inorder array for O(1) access
    private Map<Integer, Integer> inorderIndexMap;
    // Tracks the current index in the postorder array (which gives us the root nodes)
    private int postorderIndex = 0;

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        // Initialize postorder index to the last element (root of full tree)
        postorderIndex = postorder.length - 1;

        // Build the hashmap for quick index lookup in the inorder array
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start building the binary tree recursively
        return buildSubTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] postorder, int inLeft, int inRight) {
        // Base case: if there are no elements in this inorder range
        if (inLeft > inRight) {
            return null;
        }

        // Select the current root value from the postorder array
        int rootVal = postorder[postorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root in the inorder array
        int rootIndex = inorderIndexMap.get(rootVal);

        // Recursively build the right subtree using the right portion of inorder
        root.right = buildSubTree(postorder, rootIndex + 1, inRight);

        // Recursively build the left subtree using the left portion of inorder
        root.left = buildSubTree(postorder, inLeft, rootIndex - 1);

        // Return the constructed root node
        return root;
    }
}
