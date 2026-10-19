class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Double> memo = new HashMap<int[], Double>(); 

        PriorityQueue<Double> minHeap = new PriorityQueue<>(); 
        int[][] arr = new int[k][]; 

        for (int[] point : points) {
            double x1 = (double) point[0];
            double y1 = (double) point[1];
            //euclidiean distance
            double localDistance = Math.sqrt((x1*x1) + (y1*y1));
            memo.put(point, localDistance);
            minHeap.offer(localDistance); 
        }

       for (int i = 0; i < k; i++) {
            double minimumDistance = minHeap.poll();
            int[] found = null;

            for (Map.Entry<int[], Double> entry : memo.entrySet()) {
                if (entry.getValue() == minimumDistance) {
                    found = entry.getKey();
                    break;
                }
            }

            arr[i] = found;
            memo.remove(found);   // safe, we're out of the loop
        }
        return arr;

    }
}
