class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2]; 
        int index = 0; 
        for (int num : nums) {
            ans[index] = num;
            index++; 
        }

        for (int num : nums) {
            ans[index] = num;
            index++; 
        }

        return ans; 
    }
}