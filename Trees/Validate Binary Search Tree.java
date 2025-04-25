/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * 
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start the recursion with the full range of values
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper method to validate BST with min and max constraints
    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree is a valid BST
        if (node == null) return true;

        // The current node's value must be strictly between min and max
        if (node.val <= min || node.val >= max) return false;

        // Recursively validate left subtree with updated max value
        // and right subtree with updated min value
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }
}
