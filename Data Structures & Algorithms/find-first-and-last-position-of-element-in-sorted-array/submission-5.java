class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0]) return new int[] {0, 0};  
        int index = binarySearch(nums, target, 0, nums.length);
        System.out.println(index); 
        if (index == -1) return new int[] {-1, -1}; 
        int second = -1; 
        for (int i = index; i < nums.length; i++) { //2 to 4
            if (target != nums[i]) { 
                //last index was last true. 
                second = i - 1; 
                break; 
            }
        }

        if (second == -1) second = nums.length - 1; 

        int third = 0; 
        for (int i = index; i >= 0; i--) {
            if (target != nums[i]) {
                //going backwards. 
                third = i + 1; 
                break; 
            }
        }

        third = Math.min(index, third); 
        second = Math.max(index, second); 

        //loop backwards as well. 

        return new int[] {third, second}; 

    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left < right) {
            int middle = left + (right - left) / 2; 

            if (nums[middle] == target) {
                return middle; 
            }

            if (nums[middle] > target) {
                //go left. 
                right = middle; 
            }

            if (nums[middle] < target) {
                left = middle + 1; 
            }
        }

        return -1; 
    }
}