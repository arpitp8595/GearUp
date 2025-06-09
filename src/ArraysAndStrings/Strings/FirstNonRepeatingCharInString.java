package src.ArraysAndStrings.Strings;

public class FirstNonRepeatingCharInString {
    public static void main(String[] args) {
        String str = "leetcodedl";
        System.out.println("First Non-Repeating char in string: "+getNonRepeatingChar(str));
    }

    private static char getNonRepeatingChar(String str) {
        int[] count = new int[26];
        for (char c: str.toCharArray()) {
            int index = c - 'a';
            count[index]++;
        }
        
        for (char ch: str.toCharArray()) {
            if (count[ch - 'a'] == 1) {
                return ch;
            }
        }
        return '.';
    }
}
