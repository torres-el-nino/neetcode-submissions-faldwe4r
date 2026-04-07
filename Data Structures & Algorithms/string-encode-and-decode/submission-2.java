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
            int aux = i;
            while (str.charAt(aux) != '#') {
                aux++;
            }

            int length = Integer.parseInt(str.substring(i, aux));
            aux++; // skip '#'

            result.add(str.substring(aux, aux + length));
            i = aux + length;
        }

        return result;
    }
}
