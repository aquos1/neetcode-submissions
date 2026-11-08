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
    PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (Long.compare(a, b))); // min heap
    public long kthLargestLevelSum(TreeNode root, int k) {
        // at each level add up sums, then return kth largest. 

        // do bfs with size snapshot O(V + E) -> so vertice + edge, so O(n)
        // so we can use a heap to store k largest, (k heap)    
        // and just return heap.peek() -> logn for heapify.


        // if there r not enough levels to return K of them, we can return 
        // -1.


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int steps = 0; // for edge case
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr == null) continue;
                sum += (long) curr.val;
                q.offer(curr.left);
                q.offer(curr.right);
            }
            add(sum, k);
            steps++;
        }
        System.out.println(steps);
        if (steps <= k) return -1;
        return pq.peek();
    }

    public void add(long sum, int cap) {
        if (pq.size() < cap) {
            pq.offer(sum);
        } else {
            if (pq.peek() < sum) {
                pq.poll();
                pq.offer(sum);
            }
        }
    }
}
