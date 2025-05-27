package src;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), str.toCharArray(), new boolean[str.length()]);
        System.out.println(result);
    }

    private static void backtrack(List<String> result, StringBuilder temp, char[] chars, boolean[] used) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (used[i])
                    continue;
                used[i] = true;
                temp.append(chars[i]);
                backtrack(result, temp, chars, used);
                temp.deleteCharAt(temp.length() - 1); // Backtrack
                used[i] = false;
            }
        }
    }
}