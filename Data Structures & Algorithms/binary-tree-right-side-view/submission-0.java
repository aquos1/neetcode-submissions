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
        //do bfs, only append the last value in the subList. 
        Queue<TreeNode> q = new LinkedList<>(); 
        List<Integer> res = new ArrayList<>(); 
        q.offer(root); 

        while (!q.isEmpty()) {
            int size = q.size(); 
            List<Integer> subList = new ArrayList<>(); 
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll(); 
                if (curr == null) continue; 
                //atp root valid and bfs guarantees same level traversal 
                subList.add(curr.val); 
                q.add(curr.left); 
                q.add(curr.right); 
            }   
            if (subList.size() != 0) {
                res.add(subList.get(subList.size() - 1)); 
            } 
        }
        return res; 
    }
}
