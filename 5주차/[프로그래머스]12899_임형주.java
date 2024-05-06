import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') continue;
            int idx = i;
            while (idx>0 && sb.charAt(idx) == '0') {
                sb.setCharAt(idx, '4');
                sb.setCharAt(idx-1, (char)((int)((sb.charAt(idx-1)-'0')/2)+'0'));
                idx -= 1;
            }
        }

        if (sb.charAt(0)=='0') {sb.deleteCharAt(0);}
        return sb.toString();
    }
}