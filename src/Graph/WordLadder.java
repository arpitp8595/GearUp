package src.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        // Example usage
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList)); // Output: 5
    }

    //Given two words, beginWord and endWord, and a dictionary's word list,
    // find the length of the shortest transformation sequence from beginWord to endWord
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the wordList to a Set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        // Return 0 if endWord is not in the dictionary
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Queue for BFS, starting with beginWord and level 1
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Set to keep track of visited words to prevent cycles
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        // Begin BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // Dequeue the current word
                String currentWord = queue.poll();

                // Try all possible transformations
                char[] currentChars = currentWord.toCharArray();
                for (int j = 0; j < currentChars.length; j++) {
                    char originalChar = currentChars[j];
                    // Change one letter at a time
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentChars[j] = c;
                        String transformedWord = new String(currentChars);

                        // If the transformation matches the endWord, return the current level + 1
                        if (transformedWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the transformed word is in the word set and has not been visited, enqueue it
                        if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                            queue.offer(transformedWord);
                            visited.add(transformedWord);
                        }
                    }
                    // Restore original character after trying all changes
                    currentChars[j] = originalChar;
                }
            }
            // Increment level after processing all nodes at the current level
            level++;
        }

        // Return 0 if there is no valid transformation
        return 0;
    }
}
