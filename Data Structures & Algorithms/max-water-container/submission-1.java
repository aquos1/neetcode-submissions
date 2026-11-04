class Solution {
    public int maxArea(int[] heights) {
        // we are limited by the smaller one so keep 
        // moving the smaller one either inwards or outwards
        // to try something new

        // two ptr, O(n) solution and O(1) space


        int left = 0; 

        int right = heights.length - 1; 

        int max = 0;
        while (left < right) {
            if (heights[left] <= heights[right]) {
                int area = (right - left) * heights[left];
                max = Math.max(max, area);
                left++; 
            } else {
                int area = (right - left) * heights[right];
                max = Math.max(area, max); 
                right--;
            }
        }
        return max;
    }
}
