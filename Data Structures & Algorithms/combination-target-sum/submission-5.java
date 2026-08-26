class Solution {
    //guaranteed unique cuz i + 1 means we have to move forward, so 225 and 2,5,2 cannot occur. 
    //and we know int is distinct so no repeats. 
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>(); 
        dfs(nums, target, 0, 0, res, new ArrayList<>());
        return res; 
    }

    public void dfs(int[] nums, int target, int total, int index, List<List<Integer>> res, List<Integer> sub ) {
        if (total == target) {
            res.add(new ArrayList<>(sub)); 
            return; 
        }

        if (index >= nums.length || total > target) {
            return; 
        }

        //staying to reuse value -> so index is not going to change. 
        //b(index)
        sub.add(nums[index]); 
        dfs(nums, target, total + nums[index], index, res, sub); 


        //remove -> hopefully we jus appended some stuff or index >= num or total > tgt) 
        sub.remove(sub.size() - 1); 

        //moving forward. 
        dfs(nums, target, total, index + 1, res, sub); 
        //b(index + 1)
        
    }
}
