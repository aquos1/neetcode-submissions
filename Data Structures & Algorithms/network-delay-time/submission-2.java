class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        //adj List -> src node -> int[] of outgoing node and edge. 
        Map<Integer, List<int[]>> adjList = new HashMap<>(); 

        for (int[] time : times) {
            int src = time[0]; 
            int outgoing = time[1]; 
            int weight = time[2]; 

            int[] x = {outgoing, weight}; 
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<int[]>()); 
            } 
            adjList.get(src).add(x); 
        }

        for (int i = 1; i <= n; i++) {
            if (!adjList.containsKey(i)) adjList.put(i, new ArrayList<>()); 
        }

        Map<Integer, Integer> dist = new HashMap<>(); 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1])); 

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); 
            int node = curr[0], weight = curr[1]; 

            if (dist.containsKey(node)) continue; 
            //safe 
            dist.put(node, weight);

            for (int[] neigh : adjList.get(node)) {
                int nextNode = neigh[0], newWeight = neigh[1]; 
                if (!dist.containsKey(nextNode)) {
                    pq.offer(new int[] {nextNode, weight + newWeight}); 
                }
            }
        }

        if (dist.size() != adjList.size()) return -1; 
        return Collections.max(dist.values()); 






       


        
    }
}
