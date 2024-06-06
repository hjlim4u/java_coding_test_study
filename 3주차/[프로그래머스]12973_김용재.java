import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> st = new Stack<>();
        int num =0;
        for(int i=0; i<s.length();i++) {
            if(st.isEmpty()) {
                st.push(s.charAt(i));
            }
            else {
                if(st.peek()==s.charAt(i)) {
                    st.pop();
                }
                else
                    st.push(s.charAt(i));
            }
        }
        if(st.isEmpty())
            return 1;
        return 0;
    }
}