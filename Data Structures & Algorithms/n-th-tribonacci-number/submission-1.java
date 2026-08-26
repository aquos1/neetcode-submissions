public class Solution {
    private HashMap<Integer, Integer> dp = new HashMap<>();

    public int tribonacci(int n) {
        if (n == 0) {
            return 0; 
        }
        if (n == 1 || n == 2) return 1; 
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        dp.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return dp.get(n);
    }
}