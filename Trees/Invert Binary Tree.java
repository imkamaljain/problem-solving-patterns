/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * Inverting a binary tree means swapping the left and right children of all nodes in the tree.  
 * 
 * Example:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * 
 * Explanation:
 * The original binary tree is:
 *       4
 *      / \
 *     2   7
 *    / \ / \
 *   1  3 6  9
 * 
 * The inverted binary tree is:
 *       4
 *      / \
 *    7   2
 *   / \ / \
 *  9  6 3  1
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty, return null
        if (root == null) return null;

        // -------- Recursive Approach --------
        /*
        // Swap the left and right children recursively
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
        */

        // -------- Iterative Approach using BFS --------

        // Use a queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Continue until all nodes are processed
        while (!queue.isEmpty()) {
            // Remove the front node from the queue
            TreeNode curr = queue.poll();

            // Swap the left and right child of current node
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // If left child exists, add to queue for further processing
            if (curr.left != null) queue.offer(curr.left);
            // If right child exists, add to queue for further processing
            if (curr.right != null) queue.offer(curr.right);
        }

        // Return the root of the inverted tree
        return root;
    }
}
