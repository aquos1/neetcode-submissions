class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //k numbers from 1 to n
        int[] arr = new int[n]; 
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i; 
        }
        List<List<Integer>> ans = new ArrayList<>(); 
        backtrack(arr, k, 0, new ArrayList<>(), ans); 

        return ans;  
    }

    //arr = {1, 2, 3}. 

    //index = 0; 

    public void backtrack(int[] arr, int k, int index, List<Integer> subAns, List<List<Integer>> ans) {
        if (subAns.size() == k) { //2 = 2
            ans.add(new ArrayList<>(subAns)); //ans = ((1, 2), 
            return;  
        }
        //choose
            //either keep or dont keep
        if (index >= arr.length) return; //0, 1
        subAns.add(arr[index]); //subans = 1, 2
        backtrack(arr, k, index + 1, subAns, ans); //dfs(1) -> dfs(2)
        //explore
        subAns.remove(subAns.size() - 1); //subans = 1
        backtrack(arr, k, index + 1, subAns, ans); //index = 2
    }
}