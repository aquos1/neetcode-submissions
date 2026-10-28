class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length - 1];

        int answer = high; 
        while (low <= high) {
            int middle = low + (high - low)/ 2; 
            if (valid(piles, h, middle)) {
                answer = middle; 
                // answer worked, but bcuz monotonic check the other way asw so see if decreasing answer choice works more. 
                high = middle - 1; 
            } else {
                // our answer is not valid so we have to continue and see if it works w some great.er 
                low = middle + 1; 
            }
        }
        return answer; 
    }

    public boolean valid(int[] piles, int h, int currRate) {
        int currHours = 0; 
        for (int pile : piles) {
            // curr rate represents how many banana per hr i can eat. 
            currHours += Math.ceil( (double) pile / (double) currRate); 
        }

        return currHours <= h;
    }
}
