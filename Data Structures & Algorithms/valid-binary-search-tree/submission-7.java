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
    public boolean isValidBST(TreeNode root) {
        // structure:

            // base case, if node is null, u dont exist, return true.

            // otherwise, check your children
            // if both exist:
                // if .right, > cool return dfs down there.
                // if not, return f immediately.
                // if . left < cool do dfs down there
                // if not return f. 

                // can and those two together.

        

        // need to guard against NPE.
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long left, long right) {
        if (root == null) return true;

        if (!(left < root.val && root.val < right)) return false;

        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }
}
