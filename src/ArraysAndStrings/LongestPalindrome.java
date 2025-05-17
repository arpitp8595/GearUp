package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s1 = "abccccdd";
        System.out.println(longestPalindrome(s1)); // Output: 7 (Longest palindrome: "dccaccd" or "dccbccd")

        String s2 = "a";
        System.out.println(longestPalindrome(s2)); // Output: 1 (Longest palindrome: "a")

        String s3 = "aaabbb";
        System.out.println(longestPalindrome(s3)); // Output: 5 (Longest palindrome: "abbba" or "aabba")
    }

    public static int longestPalindrome(String s) {
        int oddCount = 0; // Count of characters with an odd number of occurrences
        Map<Character, Integer> map = new HashMap<>(); // HashMap to count occurrences of each character

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // Increment the count of the character in the map
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Check if the count of the character is now odd or even
            if (map.get(ch) % 2 == 1) {
                oddCount++; // Increment oddCount if the count is odd
            } else {
                oddCount--; // Decrement oddCount if the count is even
            }
        }

        // If there's more than one odd count character
        if (oddCount > 1) {
            return s.length() - oddCount + 1; // Maximum possible palindrome length
        }

        // If at most one odd count character, the entire string length can form a palindrome
        return s.length();
    }
}
