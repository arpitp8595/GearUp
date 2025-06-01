package src.ArraysAndStrings.Strings;

public class IsAnagram {
    public static void main(String[] args) {
        String firstString = "tops";
        String secondString = "pots";

        System.out.println("Are Strings Anagram?: " +isAnagram(firstString, secondString) );
    }

    private static boolean isAnagram(String firstString, String secondString) {

        if (firstString.length() != secondString.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i=0; i<firstString.length(); i++) {
            count[firstString.charAt(i) - 'a']++;
            count[secondString.charAt(i) - 'a']--;
        }

        for (int c: count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}