public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0], dst = edges[i][1];
            adj[src].add(new Pair(dst, succProb[i]));
            adj[dst].add(new Pair(src, succProb[i]));
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int node = top.node;
            double curr_prob = top.prob;

            if (node == end_node) return curr_prob;
            if (curr_prob < maxProb[node]) continue;

            for (Pair nei : adj[node]) {
                double new_prob = curr_prob * nei.prob;
                if (new_prob > maxProb[nei.node]) {
                    maxProb[nei.node] = new_prob;
                    pq.offer(new Pair(nei.node, new_prob));
                }
            }
        }

        return 0.0;
    }

    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}