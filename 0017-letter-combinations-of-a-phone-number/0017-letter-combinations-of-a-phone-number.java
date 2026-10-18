class Solution {
    HashMap<Character, String> f = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        f.put('2', "abc");
        f.put('3', "def");
        f.put('4', "ghi");
        f.put('5', "jkl");
        f.put('6', "mno");
        f.put('7', "pqrs");
        f.put('8', "tuv");
        f.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        fun(digits, digits.length(), 0, "", res);
        return res;
    }
    void fun(String s, int n, int idx, String diag, List<String> res) {
        if (idx == n) {
            res.add(diag);
            return;
        }
        String choice = f.get(s.charAt(idx));
        for (int j = 0; j < choice.length(); j++) {
            diag = diag + choice.charAt(j);

            fun(s, n, idx + 1, diag, res);

            diag = diag.substring(0, diag.length() - 1);
        }
        return;
    }
}