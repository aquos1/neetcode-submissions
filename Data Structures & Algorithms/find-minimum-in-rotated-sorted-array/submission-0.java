class Solution {
    public int findMin(int[] nums) {
        int n = nums.length; 
        // bin search over rotated arr
        // if k = rotate count, if i add count to 


        int left = 0, right = nums.length - 1; 
        int res = nums[0]; 
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                res = Math.min(res, nums[left]); 
                break; 
            }
            int middle = left + (right - left) / 2; 

            res = Math.min(res, nums[middle]); 

            if (nums[left] <= nums[middle]) {
                left = middle + 1; 
            } else {
                right = middle - 1; 
            }
        }

        return res; 
    }
}
