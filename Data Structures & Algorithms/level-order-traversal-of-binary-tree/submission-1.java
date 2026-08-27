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
        //no need for visited cuz it prev cycles or other shit but guaranteed no cycles w tree
        Queue<TreeNode> q = new LinkedList<>(); 
        List<List<Integer>> res = new ArrayList<>(); 
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
                 res.add(subList); 
            } 
        }
        return res; 
    }
}
