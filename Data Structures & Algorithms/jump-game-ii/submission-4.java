class Solution {
    int[] memo; 
    public int jump(int[] nums) {
        //array of nums -> max length of right of index i
        //nums i. = i + j where j <= nums[i]

        //i + j < length of nums

        //at nums o 

        //return min jumps to reach end
        

        this.memo = new int[nums.length]; 
        Arrays.fill(memo, -1);
        return dfs(nums, 0); 
    }


    public int dfs(int[] nums, int index) { //index = 0, 
        if (index >= nums.length - 1) return 0; //0
        if (memo[index] != -1) return memo[index]; 
        if (nums[index] == 0) {
            return 1000000;
        }
        // if (nums[index] == 0) return Integer.MAX_VALUE; 
        int choose = Integer.MAX_VALUE;
        int maxJump = Math.min(nums[index], nums.length - 1 - index);  //2, 3
        for (int i = 1; i <= maxJump; i++) { //1, 2, 1 to 3
            choose = Math.min(choose, 1 + dfs(nums, index + i)); //choose = 1 + 1 + 0 = 2. 
        }

        memo[index] = choose; 
        return memo[index]; 
    }
}
