class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(grouped.values());
    }
}
