package src.StackAndQueue;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.println("IsValid? : "+isValidParentheses(str));
    }

    public static boolean isValidParentheses(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            char currentChar = str.charAt(i);
            if(currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((currentChar == ')' && top != '(')
                        || (currentChar == ']' && top != '[')
                        || (currentChar == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
