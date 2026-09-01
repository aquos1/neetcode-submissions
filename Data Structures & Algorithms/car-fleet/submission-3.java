class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; 
        Stack<Double> s = new Stack<>(); 
        int[][] cars = new int[n][2]; 
        for (int i = 0; i < n; i++) {
            int[] car = {position[i], speed[i]}; 
            cars[i] = car; 
        }


        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        // for (int[] d : cars) {
        //     System.out.println()
        // }

        //shud be max. 

        for (int[] c : cars) {
            int pos = c[0]; 
            int sx = c[1]; 

            double time = (double) (target - pos) / sx; 
            if (s.isEmpty()) {
                s.push(time); 
            } else if (time > s.peek()) {
                s.push(time);
            }
        }
        return s.size(); 

        
    }
}
