package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.print("Is valid Palindrome: "+validPalindrome(str));
    }

    private static boolean validPalindrome(String str) {
        int length = str.length();
        int s = 0;
        int e = length-1;
        while (s <= e) {
            char currentFirst = str.charAt(s);
            char currentLast = str.charAt(e);
            if (!Character.isLetterOrDigit(currentFirst)) {
                s++;
            } else if (!Character.isLetterOrDigit(currentLast)) {
                e--;
            } else  {
                if (Character.toLowerCase(currentFirst) != Character.toLowerCase(currentLast)) {
                    return false;
                }
                s++; e--;
            }
        }
        return true;
    }
}
