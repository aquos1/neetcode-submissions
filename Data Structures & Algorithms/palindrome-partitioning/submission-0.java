class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> subAns = new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(s, 0, 0);
        return res;
    }
    // backtrack
    // see if adding any string makes palindrome still
    // so backtrack and check at each step if two ptr method passes?

    public void backtrack(String s, int j, int i) {
        if (i >= s.length()) { // we have processed every poss combo ATP
            if (i == j) {
                res.add(new ArrayList<>(subAns));
            }
            return;
        }


        if (isPalindrome(s, j, i)) {
            // choose explore unchoose
            subAns.add(s.substring(j, i + 1)); // 
            backtrack(s, i+1, i+1);
            subAns.remove(subAns.size() - 1);
        }
        backtrack(s, j, i+1);
    }


    public boolean isPalindrome(String s, int l, int r) {
        int left = l;
        int right = r;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }

        return true;
    } 
}


