package me.calebeoliveira.brackets;

import java.util.Stack;

public class BracketsProblem {
    public static void main(String[] args) {
        String string = "()[]{}()";
        System.out.println(solution(string));
    }

    private static int solution(String string) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')') {
                if(stack.isEmpty()) {
                    return 0;
                }
                Character popped = stack.pop();
                if(!(popped == '[' || popped == '{' || popped == '(')) {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
