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
                if (curr[0] == dst) return curr[1];
                if (curr[2] > k) continue; 
                if (curr[2] >= arr[curr[0]]) continue;
                arr[curr[0]] = curr[2];
                if (!hm.containsKey(curr[0])) continue; 

                for (int[] neigh : hm.get(curr[0])) {
                    //every neighbor is valid 
                    pq.offer(new int[] {neigh[0], curr[1] + neigh[1], curr[2] + 1}); 
                }
        }

        return -1; 

    }
}
