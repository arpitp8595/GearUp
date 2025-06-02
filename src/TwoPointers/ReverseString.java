package src.TwoPointers;

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
        while (s<=e) {j
            char temp = chars[s];
            chars[s] = chars[e];
            chars[e] = temp;
            s++; e--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
