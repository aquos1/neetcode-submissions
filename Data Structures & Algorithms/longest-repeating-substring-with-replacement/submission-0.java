class Solution {
    public int characterReplacement(String s, int k) {
        //string s consisting of uppercases english and integer k. 
        //can choose k char of string to replace w/ any other uppercase english letter. 
        //after K replacements, return the length of the substring which returns one char. 

        //so the GOAL: is to get longest substring where everything is the same
        //if "xyxyx" - replace ys with xs, to get output of 5.

        //xxbxxxbbb

        //can replace k character, everytime u replace decrement k. 

        //if you have K left, replace. and then count and keep going. 

        //if no k left, go again?

        Set<Character> tracker = new HashSet<>(); 
        for (char c : s.toCharArray()) {
            tracker.add(c); // xy
        }
        int result = 0; 

        for (char c : tracker) { //xy
            int count = 0;
            int left = 0; 
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == c) {
                    count++;
                }

                while ((right - left + 1) - count > k) {
                    if (s.charAt(left) == c) {
                        count--; 
                    }
                    left++; 
                }

                result = Math.max(result, right - left + 1); 
            }
        }

        return result; 

    }
}
