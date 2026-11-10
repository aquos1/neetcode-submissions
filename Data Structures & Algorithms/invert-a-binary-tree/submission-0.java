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
    public TreeNode invertTree(TreeNode root) {
        // at each parent, swap your children intul parent is null
        if (root == null) return root;
        return helper(root);
    }

    public TreeNode helper(TreeNode parent) {
        if (parent == null) return null;

        TreeNode temp = parent.right;
        parent.right = parent.left;
        parent.left = temp;

        parent.left = helper(parent.left);
        parent.right = helper(parent.right);

        return parent;
    } 
}
