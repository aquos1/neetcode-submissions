class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //i think we can hold some value constant and then try for i and j.  
      
        List<List<Integer>> res = new ArrayList<>(); 

        Arrays.sort(nums); 

        //-4, -1, -1, 0, 1, 2
        //
    for (int index = 0; index < nums.length; index++) {
        if (index > 0 && nums[index] == nums[index - 1]) continue; 

        int left = index + 1;
        int right = nums.length - 1;

        while (left < right) {
            int calc = nums[index] + nums[left] + nums[right];
            if (calc > 0) {
                right--;
            } else if (calc < 0) {
                left++;
            } else {
                res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++; // skip dups 
                while (left < right && nums[right] == nums[right + 1]) right--; // skip dups 
            }
        }
    }

        return res; 
    }
}
