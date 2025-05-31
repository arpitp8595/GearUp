package src.TwoPointers.leetcodeEasy;

public class MergeStringsAlternatively {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "stuvwxyz";
        System.out.println("Merged String : "+mergeStrings(word1, word2));
    }

    private static String mergeStrings(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int firstPointer=0; int secondPointer=0;

        while (firstPointer < word1.length() && secondPointer < word2.length()) {
            stringBuilder.append(word1.charAt(firstPointer));
            stringBuilder.append(word2.charAt(secondPointer));
            firstPointer++; secondPointer++;
        }
        while (firstPointer<word1.length() && secondPointer==word2.length()){
            stringBuilder.append(word1.charAt(firstPointer));
            firstPointer++;
        }
        while (firstPointer==word1.length() && secondPointer<word2.length()){
            stringBuilder.append(word2.charAt(secondPointer));
            secondPointer++;
        }

        return stringBuilder.toString();
    }
}
