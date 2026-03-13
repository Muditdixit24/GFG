class Solution {

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    void backtrack(String s, int index, int parts, String curr, ArrayList<String> res) {

        if (parts == 4 && index == s.length()) {
            res.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            if (isValid(segment)) {
                backtrack(s, index + len, parts + 1, curr + segment + ".", res);
            }
        }
    }

    boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;

        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}