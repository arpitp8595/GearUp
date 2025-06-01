package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures{

    public static void main(String[] args) {
        int[] temps = {73,74,75,71,69,72,76,73};
        System.out.println("Days to wait: "+ Arrays.toString(dailyTemperatures(temps)));
    }

    public static int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[t.length];
        for(int i=t.length-1; i >= 0; i--) {
            while(!st.isEmpty()&&t[i]>=t[st.peek()]) {
                st.pop();
            }
            if(!st.isEmpty())
                res[i]=st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
