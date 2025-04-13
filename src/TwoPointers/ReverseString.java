package TwoPointers;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "IntelliJ IDEA";
        System.out.print("Reversed String: "+reverseString(str));
    }

    public static String reverseString(String str) {
        int n = str.length();
        int s = 0;
        int e = n-1;
        char[] chars = str.toCharArray();
        while (s<=e) {
            char temp = chars[s];
            chars[s] = chars[e];
            chars[e] = temp;
            s++; e--;
        }
        return Arrays.toString(chars);
    }
}
