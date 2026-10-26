class Solution {
    public int maxProduct(int[] nums) {
        //given ints - find a subarrat that has LARGEST product and return it. 
        //return the product. 
        //subarray -> has to be contigious - next to each other. 
        //globalMax of product. 
        //compare to localMax of subarray products. 

        //[1,2,3,4] -> largest subarray product is 24. 

        int[] prefix = new int[nums.length];

        int curr = 0;
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr *= nums[i];
            prefix[i] = curr;
        }

        int curMax = nums[0], curMin = nums[0], best = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int a = curMax * n, b = curMin * n;
            curMax = Math.max(n, Math.max(a, b));
            curMin = Math.min(n, Math.min(a, b));
            best = Math.max(best, curMax);
        }
        return best;
    }
}
