package src.TwoPointers;

public class ReverseString2 {
    public static void main(String[] args) {
        String str = "IntelliJ IDEA";
        System.out.print("Reversed String: "+reversedString2(str));
    }

    private static String reversedString2(String str) {
        int length = str.length();
        int s = 0; int e = length-1;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = e; i >= s; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
