package src.ArraysAndStrings.Strings;

public class MinDistanceBetweenTwoWords {
    public static void main(String[] args) {
        String[] strings = { "quick", "brown", "fox", "quick"};
        String word1 = "the", word2 = "fox";
        System.out.println("Minimum distance between two words: "+getMinDistance(strings, word1, word2));
    }

    private static int getMinDistance(String[] strings, String word1, String word2) {

        int minDistance = Integer.MAX_VALUE;
        int left = 0; int right = strings.length-1;
        while (left < right) {
            int first = 0, last = 0;
            if (word1.equals(strings[left])) {
                first = left;
            }
            if (word2.equals(strings[right])) {
                last = right;
            }
            if (first != 0 && last != 0)
                minDistance = last - first;
            left++; right--;
        }

        return minDistance;
    }
}
