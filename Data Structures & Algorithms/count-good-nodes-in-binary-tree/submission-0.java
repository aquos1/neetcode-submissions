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
    public int goodNodes(TreeNode root) {
    return traverse(root, root.val); 
    }

    public int traverse(TreeNode root, int max) {
        int res = 0;
        if (root == null) return 0; 

        if (root.val >=max) {
            max = root.val; 
            res = 1; 
        } else {
            res = 0; 
        }

        res += traverse(root.left, max); 
        res += traverse(root.right, max); 

        return res; 


    }
}
