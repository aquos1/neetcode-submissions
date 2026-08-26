class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>(); 
        Arrays.sort(candidates); 
        dfs(candidates, target, 0, res, new ArrayList<>()); 
        return new ArrayList<>(res); 
    }

    public void dfs(int[] candidates, int target, int index, Set<List<Integer>> res, List<Integer> sub) {

        //have to move forward -> either ways we include or exclude each element but either ways index + 1 has to be true. 
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return; 
        }


        if (target < 0 || index >= candidates.length) return; 

        //include and exclude as child nodes -> but to guarantee only once, every step is i + 1. 
        sub.add(candidates[index]); 
        dfs(candidates, target - candidates[index], index + 1, res, sub); 
        sub.remove(sub.size() - 1);
        //excluding next options branch right 
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++; 
        }
        
        dfs(candidates, target, index + 1, res, sub); 
    }
}
