/**
 * Problem:
 * Given the root of a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * 
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * Explanation:
 *        3
 *       / \
 *      9  20
 *        / \
 *       15  7
 * 
 * All subtrees are balanced: the height difference between left and right children at each node is <= 1.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Main function to check if the binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // If the checkHeight returns -1, it means the tree is not balanced
        return checkHeight(root) != -1;
    }

    // Helper function that returns the height of the tree if balanced, or -1 if unbalanced
    private int checkHeight(TreeNode root) {
        // Base case: the height of an empty subtree is 0
        if (root == null) return 0;

        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(root.left);
        // If the left subtree is unbalanced, propagate -1 up
        if (leftHeight == -1) return -1;

        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(root.right);
        // If the right subtree is unbalanced, propagate -1 up
        if (rightHeight == -1) return -1;

        // Check if the current node is balanced
        // If the height difference is more than 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // If balanced, return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
