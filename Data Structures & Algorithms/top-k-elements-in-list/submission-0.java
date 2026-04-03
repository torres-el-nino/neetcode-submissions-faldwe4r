class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums;
        }

        Map<Integer, Long> result = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        return result.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
