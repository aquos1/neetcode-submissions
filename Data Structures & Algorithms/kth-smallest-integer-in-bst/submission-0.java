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
    int count; 
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        // o (n) brute force, go thru every value and add into max heap and return peek()
        // o (log n) sol, 
        count = k; 

        dfs(root);

        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        count--;
        if (count == 0) ans = root.val;
        System.out.println(root.val);
        dfs(root.right);
    }
}
