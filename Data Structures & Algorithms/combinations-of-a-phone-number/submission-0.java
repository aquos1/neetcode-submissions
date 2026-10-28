class Solution {
    List<String> ans = new ArrayList<>(); 
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        backtrack(0, new StringBuilder(), digits); 
        return ans;
    }

    private void backtrack(int i, StringBuilder subAns, String digits) {
        if (subAns.length() == digits.length()) {
            StringBuilder s = new StringBuilder(subAns);
            ans.add(s.toString());
            return;
        }

        String choices = digitToChar[digits.charAt(i) - '0'];

        for (char ch : choices.toCharArray()) {
            // choose, explore, unchoose
            subAns.append(ch);
            backtrack(i+1, subAns, digits);
            subAns.deleteCharAt(subAns.length() - 1);
        }
    }
}
