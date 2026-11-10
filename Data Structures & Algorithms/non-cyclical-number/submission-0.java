class Solution {
    public boolean isHappy(int n) {

        //sum tracker in set

        //while the sum != 1, keep going, 
        // if contains, we can r false.

        // if we get thru and find 1 we can r true

        Set<Integer> tracker = new HashSet<>();

        while (n != 1) {
            if (tracker.contains(n)) return false;
            tracker.add(n);
            int sum = 0;
            int curr = n;
            while (curr > 0) {
                int rem = curr % 10; 
                sum += Math.pow(rem, 2);
                curr /= 10;
            }
            n = sum;
        }

        return true;
        
    }
}
