package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "abcabcdbb";
        System.out.println("Result: "+lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {// O(n) O(1)
        // Initialize the left pointer of the sliding window to 0
        int l = 0;
        // Variable to keep track of the maximum length of substring found
        int maxLength = 0;
        // A Set to store unique characters of the current window
        Set<Character> set = new HashSet<>();

        // Iterate the right pointer of the sliding window over the string
        for (int r = 0; r < s.length(); r++) {
            // While the current character is already in the set (duplicate character found)
            while (set.contains(s.charAt(r))) {
                // Remove character at the left pointer from the set to shrink the window
                set.remove(s.charAt(l));
                // Move the left pointer to the right
                l++;
            }
            // Add the current character at the right pointer to the set
            set.add(s.charAt(r));
            // Calculate the length of the current window and update the maximum length
            maxLength = Math.max(maxLength, (r - l) + 1);
        }
        // Return the maximum length of substring without repeating characters
        return maxLength;
    }
}
