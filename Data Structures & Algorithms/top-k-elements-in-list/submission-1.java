class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        // Create a map to store number -> frequency
        HashMap<Integer, Integer> frequency = new HashMap<>();

        // Count how many times each number appears
        for (int num : nums) {
            // If number already exists, increase count, otherwise start at 1
            int count = frequency.get(num) != null 
                    ? frequency.get(num) + 1 
                    : 1;

            // Update the map
            frequency.put(num, count);
        }

        // Create a list to store (frequency, number) pairs
        List<int[]> arr = new ArrayList<>();

        // Convert map entries into list of arrays
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        // Sort the list by frequency in descending order
        arr.sort((a, b) -> b[0] - a[0]);

        // Prepare result array of size k
        int[] res = new int[k];

        // Take top k elements (most frequent numbers)
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        // Return the result
        return res;
    }
}
