class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0; 
        Set<Character> sy = new HashSet<>();
        char[] sx = s.toCharArray(); 
        while (right < sx.length) { // "zxyzxyz"
            if (!sy.contains(sx[right])) {//
                sy.add(sx[right]); //sy = xyz
                right++; //1, 2, 3, 4
            } else {
                //if there is a repeating character. 
                max = Math.max(max, right - left);  // 3
                sy.remove(sx[left]); //sy = xy
                left++; //left = 1. 
            }
        }

        max = Math.max(max, right - left);

        return max; 
     }
}
