class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> s = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            // [temp, index]
            while (!s.isEmpty() && s.peek()[0] < temp) {
                int[] x = s.pop();
                res[x[1]] = i - x[1];
            }
            s.push(new int [] {temp, i});
        }
        return res;
    }
}
