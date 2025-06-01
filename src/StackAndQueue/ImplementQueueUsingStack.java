package src.StackAndQueue;

import java.util.Stack;

class MyQueue{

    private Stack<Integer> input;
    private  Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
        input.push(x);

    }

    public int pop() {
        if (!input.empty()) {
            return -1;
        }
        return output.pop();
    }

    public int peek() {
        if (input.empty()) {
            return -1;
        }
        return input.peek();
    }

    public boolean empty() {
        return input.empty();
    }
}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {


        //Your MyQueue object will be instantiated and called as such:
        MyQueue obj = new MyQueue();
        obj.push(24);
        obj.push(52);
        obj.push(8);
        obj.push(2);
        obj.push(9);
        obj.push(7);
        obj.push(15);
        int param_2 = obj.pop();
        System.out.println("Recently popped element: "+param_2);
        int param_3 = obj.peek();
        System.out.println("Recently peeked element: "+param_3);
        boolean param_4 = obj.empty();
        System.out.println("Is queue empty? : "+param_4);
    }
}
