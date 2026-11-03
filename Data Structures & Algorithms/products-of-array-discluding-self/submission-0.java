class Solution {
    public int[] productExceptSelf(int[] nums) {
        // prefix sum 

        int product = 1; 
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n]; 
        
        // at each index, on the left we have everyhting before
        // everything after

        pref[0] = 1; 
        suff[n - 1] = 1;

        //pref shud be 1, 2, 8, 48

        // suff shud be

        // 48, 8, 4, 1

        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i+1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res; 
    }
}  
