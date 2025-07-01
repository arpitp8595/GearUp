package src.ArraysAndStrings.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println("Longest Palindrome could be of length: "+getLongestPalindrome(str));
    }

    public static int getLongestPalindrome(String str) {
        int resultCount = 0;
        boolean oddFound = false;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch: str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (int n: frequencyMap.values()) {
            if (n % 2 == 0) {
                resultCount += n;
            } else {
                resultCount += n - 1;
                oddFound = true;
            }
        }
        if (oddFound) {
            resultCount++;
        }

        return resultCount;
    }
}
