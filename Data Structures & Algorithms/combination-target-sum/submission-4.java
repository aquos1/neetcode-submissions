class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        backtrack(nums, target, 0, res, new ArrayList<>()); 
        return res; 
    }

    public void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> sub) {
        
        if (target == 0) {
            res.add(new ArrayList<>(sub)); 
            return; 
        }

        if (target < 0 || i >= nums.length) {
            return; 
        }
    

        sub.add(nums[i]); 
        backtrack(nums, target - nums[i], i, res, sub);
        sub.remove(sub.size() - 1); 
        backtrack(nums, target, i + 1, res, sub); 
    }
}
