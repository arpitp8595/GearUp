package src.ArraysAndStrings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharInString {
    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println("First Unique Character: "+firstUniqueCharInString(str));
    }

    private static int firstUniqueCharInString(String str) {
        int[] count = new int[26];
        for (char c: str.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }
        for (int i=0; i<str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //If the input includes Unicode characters (beyond a-z), use a LinkedHashMap:
    //HashMap is the fastest but unordered.
    //LinkedHashMap keeps insertion order.
    //TreeMap sorts keys but is slower.
    public static int firstUniqueCharInString1(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqueCharInString2(String s) {
        int index = -1;
        for(char ch : s.toCharArray()) {
            if(s.indexOf(ch) == s.lastIndexOf(ch)) {
                return s.indexOf(ch);
            }
        }
        return index;
    }
}
