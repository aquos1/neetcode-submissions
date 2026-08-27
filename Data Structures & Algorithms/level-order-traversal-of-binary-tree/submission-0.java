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
    Map<Integer, List<Integer>> tm = new TreeMap<>(); 

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        traverse(root, 0); 
        for (Map.Entry<Integer, List<Integer>> entry : tm.entrySet()) { //also o(n) in lists. 
            //should be sorted.
            res.add(entry.getValue()); 
        }

        return res; 
    }

    public void traverse(TreeNode root, int index) { // this is o(nodes in lsit)
        if (root == null) return; //root = 1, 2, 4

        if (tm.containsKey(index)) { //
            tm.get(index).add(root.val);
        } else { //
            tm.put(index, new ArrayList<>()); // 
            tm.get(index).add(root.val); // 0 -> 1, 1 -> 2, 3, 2 -> 4, 5, 6, 7. 
        }

        traverse(root.left, index + 1); //index is curr 0, node 1 to node 2 && , node 2 to 4 && index = 1, node 4 to null and index == 2. null returns. 
        traverse(root.right, index + 1); //4 returns null for both children. 

        //2 will go to right and its index will be 1 + 1 to 2 again (in that prev call index was only 1). 
    }
}
