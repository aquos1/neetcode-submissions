class Solution {
    public int maxProfit(int[] prices) {
        // two pointer approach:
            //left & right pointer
            //left would be buy
            //right would be sell.

            // left < right.

        // loop thru
            // if val on the right is < then the one on left
                // left = right. 
                // rght = left + 1.

            // if right > left, 

                // check profit, store max somewhere. 


        // return max.

        int left = 0;
        int right = 1;
        int max = 0;

        //  prices = [10,1,5,6,7,1]
        while (right < prices.length) { // check bounds
            if (prices[right] < prices[left]) {
                left = right;
                right = left + 1;
            } else {
                int localProfit = prices[right] - prices[left]; // 5
                max = Math.max(max, localProfit);
                right++;
            }
        }

        return max; 


    }
}
