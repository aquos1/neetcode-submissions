class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //at each point, does our answer alr contain nums[i]; 
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> valid = new ArrayList<>(); 
        dfs(nums, 0, res, valid) ;
        return res; 
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> valid) {
        if (valid.size() == nums.length) {
            res.add(new ArrayList<>(valid)); 
            return; 
        }

        for (int num : nums) {
            if (valid.contains(num)) continue; 
            valid.add(num); 
            dfs(nums, index, res, valid); 
            valid.remove(valid.size() - 1); 
        }
    }
}
