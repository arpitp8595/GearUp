package src.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        // Example usage
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String[] wordList1 = {"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength1(beginWord, endWord, wordList1)); // Output: 5
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

    static class Pair{
        String word;
        int stepCount;
        Pair(String word, int stepCount) {
            this.word = word;
            this.stepCount = stepCount;
        }
    }

    public static int ladderLength1(String startWord, String targetWord, String[] wordList) {
        // Initialize the BFS queue with the initial word and step count
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        // Convert the word list to a set for fast lookup and removal
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        // Early exit if the target word is not in the word list
        if (!wordSet.contains(targetWord)) {
            return 0;
        }

        // Process each word in the queue
        while (!q.isEmpty()) {
            Pair currentPair = q.remove();
            String word = currentPair.word;
            int stepCount = currentPair.stepCount;

            // If the target word is found, return the number of stepCount
            if (word.equals(targetWord)) {
                return stepCount;
            }

            // Try all possible single-character transformations
            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (wordChars[i] == ch) continue; // Skip if the character is the same

                    // Replace the i-th character with `ch`
                    wordChars[i] = ch;
                    String transformedWord = new String(wordChars);

                    // If the transformed word is in the set, add it to the queue and remove from the set
                    if (wordSet.contains(transformedWord)) {
                        wordSet.remove(transformedWord);
                        q.add(new Pair(transformedWord, stepCount + 1));
                    }
                }
            }
        }
        // Return 0 if no transformation sequence is found
        return 0;
    }
}
