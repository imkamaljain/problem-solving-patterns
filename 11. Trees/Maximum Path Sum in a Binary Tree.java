/**
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Example:
 * 
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * 
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */

class Solution {
    // Global variable to track the max path sum
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // Start postorder DFS
        dfs(root);
        return maxSum;
    }

    /**
     * Returns the maximum gain from this node to its parent (one side only).
     * Also updates maxSum for paths that pass through this node.
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Recurse on left and right subtrees. If negative, ignore (take 0).
        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);

        // Path through the current node (can include both children)
        int currentPathSum = node.val + leftSum + rightSum;

        // Update global max path sum if this is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain to parent (only one direction allowed in path)
        return node.val + Math.max(leftSum, rightSum);
    }
}
