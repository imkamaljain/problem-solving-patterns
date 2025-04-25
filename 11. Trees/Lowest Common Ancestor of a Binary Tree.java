/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * 
 * Explanation:
 * The LCA of nodes 5 and 1 is 3.
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null, or root matches p or q, return root.
        // This means we've found one of the nodes or reached the end of a path.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for LCA in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, it means p and q are found in
        // different subtrees of the current root, so root is their LCA.
        if (left != null && right != null) {
            return root;
        }

        // If only one of the left or right is non-null, return the non-null node.
        // This means either both nodes are in one subtree, or only one was found.
        return left != null ? left : right;
    }
}