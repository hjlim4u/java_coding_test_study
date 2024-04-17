import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (c=='('){
                stack.add("(");
            } else{
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        if (!stack.empty()) return false;
        return answer;
    }
}