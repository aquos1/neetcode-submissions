class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //construct adj list
            //from -> List<[to, price]. 
        //djikstras

        Map<Integer, List<int[]>> hm = new HashMap<>(); 

        for (int[] flight : flights) {
            int from = flight[0]; 
            int to = flight[1]; 
            int price = flight[2]; 

            if (!hm.containsKey(from)) {
                hm.put(from, new ArrayList<>()); 
            } 

            hm.get(from).add(new int[] {to, price}); 
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1])); 
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        pq.offer(new int[] {src, 0, 0}); 
        while (!pq.isEmpty()) {
                int[] curr = pq.poll(); 
                int source = curr[0]; 
                int priceUntilPoint = curr[1]; 
                int currSteps = curr[2]; 
                if (source == dst) return priceUntilPoint;
                if (currSteps > k) continue; 
                if (currSteps >= arr[source]) continue; 
                arr[source] = currSteps;
                if (!hm.containsKey(source)) continue; 

                for (int[] neigh : hm.get(source)) {
                    //every neighbor is valid 
                    pq.offer(new int[] {neigh[0], priceUntilPoint + neigh[1], currSteps + 1}); 
                }
        }

        return -1; 

    }
}
