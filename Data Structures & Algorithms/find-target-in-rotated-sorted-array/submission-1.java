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


        // key idea:
        // 1) check to see if the list is sorted or not (which half is sorted)
        // 2) check to see where the target value should live amongst 
        // both halves. 


        while (left <= right) {
            int middle = left + (right - left) / 2; //i = 2 
            if (nums[middle] == target) return middle; //5 != 1
            if (nums[middle] >= nums[left]) { // if this is true, then the left half of the list is sorted so we know that it at least is somewhat sorted. 
            // then we can do value checks. 
                if (target > nums[middle] || target < nums[left]) {
                    // if the target is greater than the middle we need to 
                    // explore that sorted half. 
                    // or if the target is LESS than left (woah) 
                        // this works bcuz tgt < left < middle for sure if in this block. so that implies that the left sorted half cud be the big values or something and we need small values which is after middle. 
                    left = middle + 1; 
                } else {
                    // if the tgt is < nums[middle] then shrink. 
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
