class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum arr - w/ running total
        //2, 1, 2, 4
        //so sum == prefix[j] - prefix[i] + nums[i].

        //if that sum == k, loop thru i to j and add ts up. 


        //prefix
        int[] prefix = new int[nums.length]; 
        int total = 0; 
        int ans = 0; 
        for (int i = 0; i < nums.length; i++) {
            total += nums[i]; 
            prefix[i] = total;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefix[j] - prefix[i] + nums[i]; 
                if (sum == k) {
                    ans++; 
                }
            }
        }
        return ans; 
    }
}