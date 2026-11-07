class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //directed graph
        // 1 to n

        // times is [src, tgt, weight / time]

        // k is starting node

        // return the min time for all N nodes to receive the signal.

        // if impossible, return -1.

        // graphs:
            //dfs, bfs, djikstras
        // spt
            //bfs, djikstras.

        // bfs is not g w weights.

        //djikstras uses a Priority queue so it is good w weights, and will give us SPT.

        // algo:

        //1) adj List from times

            // hm, src -> list of neighbors
                // neigh is a pair, where pair a class where int is the tgt, and time is the 
                // other weight. 

        //2) pq is minHeap -> where we sort on weights. 

        // visited[node] = true, then it works. 
        //3) algo:
            // heap not empty
            // store size
            // for loop thru size. (level)
        

        //everytime we add to pq, we mark as true. 

        int[] seen = new int[n + 1];
        Arrays.fill(seen, Integer.MAX_VALUE);
        seen[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1]))); // shud be minheap

        pq.offer(new int [] {k, 0});

        // adj list

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int src = time[0];
            int tgt = time[1];
            int weight = time[2];
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            graph.get(src).add(new int [] {tgt, weight});
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int src = curr[0];
            int weight = curr[1];

            if (weight > seen[src]) continue;

            for (int[] neigh : graph.getOrDefault(src, new ArrayList<>())) {
                int neighNode = neigh[0];
                int neighWeight = neigh[1];
                if (neighWeight + weight >= seen[neighNode]) continue;
                seen[neighNode] = weight + neighWeight;
                pq.offer(new int [] {neighNode, neighWeight + weight});
            }
        }
        int currMin = Integer.MIN_VALUE;
        for (int i = 1; i < seen.length; i++) {
            if (seen[i] == Integer.MAX_VALUE) {
                return -1; 
            } else {
                if (seen[i] > currMin) currMin = seen[i]; 
            }
        }
        return currMin;
    }
}
