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
    List<String> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        // backtracking where we make numbers, store them in a aux ds,
        // then loop thru aux ds and do Integer.parseInt(String)
        dfs(root, new StringBuilder());
        int sum = 0;
        for (String val : res) {
            sum += Integer.parseInt(val);
        }
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder ans) {
        if (root == null) return; // so we can do dfs(null) its fine

        if (root.left == null && root.right == null) {
            // going to add 1 early and not act take the last node value.
            ans.append(String.valueOf(root.val)); // 15
            res.add(new String(ans)); // 15
            ans.deleteCharAt(ans.length() - 1);
            return;
        }

        // choose, explore, unchoose

        ans.append(String.valueOf(root.val)); // 11
        dfs(root.left, ans);
        dfs(root.right, ans); // 
        ans.deleteCharAt(ans.length() - 1);
    }
}