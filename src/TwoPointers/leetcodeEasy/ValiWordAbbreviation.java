package src.TwoPointers.leetcodeEasy;

public class ValiWordAbbreviation {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println("Is Valid Abbreviation? : "+validWordAbbreviation(word, abbr));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int num = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                int digit = abbr.charAt(j) - '0';
                if (num == 0 && digit == 0) return false;
                j++;
                num = num * 10 + digit;
            } else {
                i += num;
                if (i >= word.length()) return false;
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
                num = 0;
            }
        }
        return i + num == word.length() && j == abbr.length();
    }
 }
