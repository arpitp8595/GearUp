package src.StackAndQueue;

public class MinAddToMakeValidParentheses {
    public static void main(String[] args) {
        String parentheses = "(()((";
        System.out.println("Minimum addition required to make parentheses valid: "+minAddForValidParentheses(parentheses));
    }

    public static int minAddForValidParentheses(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty()){
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        count += stack.size();
        return count;
    }
}
