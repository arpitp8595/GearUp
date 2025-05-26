package ArraysAndStrings;

public class RepeatingCharInString {
    public static void main(String[] args) {
        String str = "aleetcode";
        System.out.println("First Letter to Appear Twice: "+repeatedCharacter(str));
    }

    //O(N) O(1)
    private static char repeatedCharacter(String s) {
        int[] cnt = new int[26]; // Tracks counts of 'a' to 'z'
        for (char c : s.toCharArray()) {
            // Convert character to index (e.g., 'a' -> 0, 'b' -> 1)
            int index = c - 'a';
            cnt[index]++; // Increment count for this character
            if (cnt[index] == 2) {
                return c; // Found the first duplicate
            }
        }
        return '.'; // Only if no duplicates exist
    }
}
