/**
 * Problem:
 * Given the root of a binary tree, return an array containing the values of the rightmost nodes at each level of the tree.
 * The rightmost node is the last node encountered at each level during a level-order traversal (BFS).
 * 
 * Example:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 
 * Explanation:
 * The binary tree is represented as:
 *       1
 *      / \
 *     2   3
 *      \    \
 *       5    4
 * The rightmost nodes at each level are:
 * Level 0: 1
 * Level 1: 3
 * Level 2: 4
 * Therefore, the output is [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the final result
        List<Integer> res = new LinkedList<>();

        // If the tree is empty, return an empty list
        if (root == null) return res;

        // Initialize a queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Dequeue the current node

                // If it's the last node in the current level, add it to the result
                if (i == size - 1) {
                    res.add(node.val);
                }

                // Add left child to the queue if it exists
                if (node.left != null) queue.offer(node.left);

                // Add right child to the queue if it exists
                if (node.right != null) queue.offer(node.right);
            }
        }

        // Return the list containing rightmost nodes at each level
        return res;
    }
}
