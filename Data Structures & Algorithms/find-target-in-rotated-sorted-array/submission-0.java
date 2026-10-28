class Solution {
    public int search(int[] nums, int target) {
        // can do bin search w l = 0, right = 5. 


        // if we calculate middle index, 0 + 5 / 2 = 2. 
        // and our middle value is > left (5 > 3), then we know the answer is on the RIGHT of the middle.
        // so low can be middle + 1. 
        // if our middle value is < than the right value, then we shud shrink and make high = middle - 1. 


        // base case can be to return index if middle == target,

        // and if left <= right is done and we dont return return -1. 
        int left = 0;
        int right = nums.length - 1; 

        //6, 1, 2, 3, 4, 5 == tgt = 4.


        // 

        while (left <= right) {
            int middle = left + (right - left) / 2; //i = 2 
            if (nums[middle] == target) return middle; //5 != 1
            if (nums[middle] >= nums[left]) {
                if (target > nums[middle] ||target < nums[left]) {
                    left = middle + 1; 
                } else {
                    right = middle - 1; 
                }
            } else {
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1; 
                } else {
                    left = middle + 1; 
                }
            }
        }
        return -1; 
    }
}
