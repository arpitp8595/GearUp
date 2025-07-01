package src.StackAndQueue;

import java.util.Stack;


/*
Push(x) : ( O(n) ) (because we transfer elements twice)
Pop()   : ( O(1) ) (just popping the top element)
Peek()  : ( O(1) ) (accessing the top element)
Empty() : ( O(1) ) (checking if the stack is empty)
*/
class QueueUsingStacks{
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int newElement) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(newElement);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public void printQueue() {
        if (s1.empty()) {
            System.out.println("Queue is empty.!");
        }

        System.out.print("Result: ");
        while (!s1.empty()) {
            int currentElement = s1.pop();
            System.out.print(currentElement+" ");
        }
    }
}

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {


        //Your MyQueue object will be instantiated and called as such:
        QueueUsingStacks obj = new QueueUsingStacks();
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
        boolean param_4 = obj.isEmpty();
        System.out.println("Is queue empty? : "+param_4);
        System.out.println("Final Stack: "); obj.printQueue();
    }
}
