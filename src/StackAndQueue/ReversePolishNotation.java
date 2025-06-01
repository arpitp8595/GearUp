package src.StackAndQueue;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Result of RPN: "+evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c: tokens) {
            switch (c) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                }
                default -> stack.push(Integer.parseInt(c));
            }
        }
        return stack.peek();
    }
}
