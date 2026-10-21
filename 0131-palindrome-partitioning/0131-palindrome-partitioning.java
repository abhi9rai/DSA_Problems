class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        fun(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    void fun(String s, int start, List<String> list, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                list.add(sub);
                fun(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
