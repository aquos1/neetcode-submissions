class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0; 
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight; 
        }

        int ans = high; 

        while (low <= high) {
            int middle = low + (high - low) / 2; 
            if (valid(weights, days, middle)) {
                // if this returns true then the middle case worked so we can check even smaller. 
                // but the answer is stil valid.
                ans = middle; 
                high = middle - 1; 
            } else {
                low = middle + 1; 
            }   
        }
        return ans; 
    }


    public boolean valid(int[] weights, int days, int maxCap) {
        int currWeight = 0; 
        int daysNeeded = 1; 

        for (int weight : weights) {
            if (currWeight + weight > maxCap) {
                daysNeeded++; 
                currWeight = 0; 
            }
            currWeight += weight; 
        }
        return daysNeeded <= days;  
    }
}