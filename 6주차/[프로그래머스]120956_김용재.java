import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        HashSet<String> s = new HashSet<>();
        s.add("aya");
        s.add("ye");
        s.add("woo");
        s.add("ma");
        for(String t: babbling) {
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<t.length();i++) {
                if(s.contains(sb.toString())) {
                    sb = new StringBuilder("");
                }
                sb.append(t.charAt(i));
            }
            if(s.contains(sb.toString())) {
                answer++;
            }
        }
        return answer;
    }
}