class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // flights is from, to , and price or the edge.

        // k,v pair as from -> list<int[]> where each int[] is to, and price.


        // we run djikstras
            // but we keep updating the price array within the pq


        // add src airport to the pq

        // capture size, explore neighbors
        // for each neighbor we explore, we can change the price to be total proce
        // also want steps so we track steps (to make sure < k)

        // if the node we r exploring rn is == dst, then we can return the price at that point.

        //minHeap where we sort on price. 

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[] {src, 0, 0}); // src, cost, steps until now
        Map<Integer, List<int[]>> neighbors = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            if (!neighbors.containsKey(from)) {
                neighbors.put(from, new ArrayList<>());
            }
            neighbors.get(from).add(new int [] {to, cost});
        }

        Map<Integer, Integer> minStops = new HashMap<>(); // visited set

        while (!pq.isEmpty()) {
            // pq shud be reorging
            int[] curr = pq.poll();
            int source = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            if (source == dst) return cost;
            if (stops > k) continue;

            if (minStops.containsKey(source) && minStops.get(source) < stops) {
                continue;
            }
            minStops.put(source, stops);

            for (int[] neigh : neighbors.getOrDefault(curr[0], new ArrayList<>())) {
                pq.offer(new int[] {neigh[0], neigh[1] + cost, stops + 1});
            }
        }


        return -1; 
    }
}
