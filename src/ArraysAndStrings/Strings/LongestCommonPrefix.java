package src.ArraysAndStrings.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("Longest Common Prefix: "+getLongestCommonPrefix(str));
    }

    private static String getLongestCommonPrefix(String[] str) {
        Arrays.sort(str);

        String first = str[0];
        String last = str[str.length-1];
        int minLength = Math.min(first.length(), last.length());

        int index=0;
        while (index<first.length() && index<last.length()) {
            if (first.charAt(index) == last.charAt(index)) {
                index++;
            } else {
                break;
            }
        }


        return last.substring(0, index);
    }
}
