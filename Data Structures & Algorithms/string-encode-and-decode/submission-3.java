class Solution {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
                    .append("#")
                    .append(s);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int cursor = i;
            while (str.charAt(cursor) != '#') {
                cursor++;
            }

            int length = Integer.parseInt(str.substring(i, cursor));
            cursor++; // skip '#'

            result.add(str.substring(cursor, cursor + length));
            i = cursor + length;
        }

        return result;
    }
}
