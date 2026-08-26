class Solution {
    List<List<Integer>> res; 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>(); 
        Arrays.sort(nums); 
        backtrack(nums, 0, res, new ArrayList<>()); 
        return new ArrayList<>(res); 
    }

    public void backtrack(int[] nums, int index, List<List<Integer>> res, List<Integer> sub) {
        

        // nums = [1,2,1]
        // [[],[1],[1,2],[1,1],[1,2,1],[2]]

        //two choices, either we include or we exclude current. thats it. -> either ways index + 1
        //we can return when index is == nums.length

        if (index == nums.length) { 
            //can sort here? is that waste of time.
            res.add(new ArrayList<>(sub)); //res = (1,2,1), 1,2
            return; 
        }

        //two choices
        

        //include
        sub.add(nums[index]); //1, 2, 1
        backtrack(nums, index + 1, res, sub); 
        sub.remove(sub.size() - 1); //1

        //exclude 
        while (index + 1 < nums.length && nums[index] == nums[index+1]) {
            index++; 
        }
        backtrack(nums, index + 1, res, sub); //1, 2 -> i == 3
    }   
}
