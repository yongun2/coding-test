import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        if (s.charAt(0) == ')') return false;
        
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                } 
                stack.pop();
            }
        }
        
        return stack.size() == 0;
    }
}