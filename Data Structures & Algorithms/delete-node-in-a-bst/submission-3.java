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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key); 
    }  

    public TreeNode dfs(TreeNode root, int key) {
        TreeNode curr = root; 
        if (curr == null) return null; 

        if (curr.val < key) {
            //go right 
            curr.right = dfs(root.right, key); 
            return curr; 
        }

        if (curr.val > key) {
            //go left
            curr.left = dfs(root.left, key); 
            return curr; 
        }

        if (key == curr.val) {
             TreeNode nodeToRemove = curr; 
            if (nodeToRemove.left == null && nodeToRemove.right == null) return null; 

            if (curr.right == null) return curr.left;   // fixes self-loop
            if (curr.left == null) return curr.right;

            TreeNode nodeParent = curr.right; 
            attachleft(nodeParent, nodeToRemove.left);  // fixes losing right.left
            return nodeParent; 

        }

        return root; 
    }

    public void attachleft(TreeNode node, TreeNode sub) {
        if (node.left == null) {
            node.left = sub; 
            return; 
        }

        attachleft(node.left, sub); 
    }
}