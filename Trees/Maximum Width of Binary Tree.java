/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 * The maximum width of a tree is the maximum width among all levels.
 * 
 * Example:
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * 
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 */

class Solution {
    
    // Custom class to hold a TreeNode and its corresponding index in the virtual complete binary tree
    static class NodeIndex {
        TreeNode node;
        int index;

        NodeIndex(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // Queue for level order traversal, storing nodes with their indices
        Queue<NodeIndex> queue = new LinkedList<>();
        queue.offer(new NodeIndex(root, 0)); // Start with root at index 0

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Normalize indices by subtracting the index of the first node in the level
            int minIndex = queue.peek().index;
            
            int first = 0, last = 0; // To track leftmost and rightmost node indices in the level

            for (int i = 0; i < size; i++) {
                NodeIndex current = queue.poll();
                
                // Normalize index to avoid integer overflow
                int index = current.index - minIndex;

                // Store the first and last index in this level
                if (i == 0) first = index;
                if (i == size - 1) last = index;

                // Add left child to queue with index 2 * index
                if (current.node.left != null) {
                    queue.offer(new NodeIndex(current.node.left, 2 * index));
                }

                // Add right child to queue with index 2 * index + 1
                if (current.node.right != null) {
                    queue.offer(new NodeIndex(current.node.right, 2 * index + 1));
                }
            }

            // Update the maximum width: last - first + 1
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
