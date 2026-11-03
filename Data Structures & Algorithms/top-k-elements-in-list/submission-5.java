class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // hm for freq counting
        // array of lists<> 
            // each index represents a freq (key in via freq)
            // add the value 

        // loop backwards thru array until a list is non empty
            // keep k counter, and if list is non empty we can add those to ans array.
        Map<Integer, Integer> freqCounting = new HashMap<>();

        for (int num : nums) {
            if (!freqCounting.containsKey(num)) {
                freqCounting.put(num, 1);
            } else {
                freqCounting.put(num, freqCounting.get(num) + 1);
            }
        }

        List<Integer>[] arr = new ArrayList[nums.length + 1]; 

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>(); // Unique list per bucket
        }

        for (Map.Entry<Integer, Integer> entry : freqCounting.entrySet()) {
            int freq = entry.getValue();
            arr[freq].add(entry.getKey());
        }

        // for (List<Integer> valueList : arr) {
        //     System.out.println(valueList.get(0)); 
        // }

        int[] ans = new int[k]; 
        int track = 0; 

        for (int i = arr.length - 1; i >= 0; i--) {
            if (k != 0 && arr[i].size() != 0) {
                List<Integer> ofInterest = arr[i];
                for (int val : ofInterest) {
                    if (k != 0) {
                        ans[track] = val; 
                        k--;
                        track++;
                    }
                }
            }
        }

        return ans;
    }
}
