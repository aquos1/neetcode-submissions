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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) continue;
                q.offer(curr.left);
                q.offer(curr.right);
                subAns.add(curr.val);
            }
            if (subAns.size() != 0) ans.add(subAns);
        }
        return ans;
    }
}
