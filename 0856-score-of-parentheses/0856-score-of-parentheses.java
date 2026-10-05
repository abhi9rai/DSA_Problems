class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(0);
            }
            else {
                int a = st.pop();
                if(a == 0) {
                    a = 1;
                }
                else {
                    a = 2 * a;
                }
                if(!st.isEmpty()) {
                    int b = st.pop();
                    st.push(b + a);
                }
                else {
                    st.push(a);
                }
            }
        }
        return st.pop();
    }
}