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
    public TreeNode replaceValueInTree(TreeNode root) {
        // obsv: root, and children seem to always be 0? bcuz parent == same, 


        // can use depth tracker, if depth is == to 0, 1 then each val is == 0.

        // otherwise we can do bfs, and add up sum of the cousins and then pop the other side?

        // bfs for sums 

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode current = root;
        q.offer(current);

        Map<Integer, Integer> sums = new HashMap<>();
        int level = 0;
        sums.put(level, 0);
        sums.put(1, 0);

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) continue;
                sum += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }            
            if (level != 1) sums.put(level, sum);
            level++;
        }
        TreeNode curr1 = root;
        curr1.val = 0;
        if (root.left != null) root.left.val = 0;
        if (root.right != null) root.right.val = 0;
        if (root.left != null) q.offer(root.left);
        if (root.right != null) q.offer(root.right);
        int steps = 1; 

        while (!q.isEmpty()) {
            // this time we want to take our parent and have it access levelsum via map and then do math.
            int size = q.size();
            int totalSum = sums.getOrDefault(steps + 1, 0);
            for (int i = 0; i < size; i++) { // represents level
                TreeNode curr = q.poll(); // lets say this is the parent
                int childrenSiblingSum = 0;
                if (curr == null) continue;
                if (curr.left != null && curr.right != null) {
                    childrenSiblingSum = curr.left.val + curr.right.val;
                    curr.left.val = totalSum - childrenSiblingSum;
                    curr.right.val = totalSum - childrenSiblingSum;
                } else if (curr.left != null) {
                    childrenSiblingSum = curr.left.val;
                    curr.left.val = totalSum - childrenSiblingSum;
                } else if (curr.right != null) {
                    childrenSiblingSum = curr.right.val;
                    curr.right.val = totalSum - childrenSiblingSum;
                } else {
                    continue;
                }
                q.offer(curr.left);
                q.offer(curr.right);
            }
            steps++;
        }

        return root;
    }
}
