package src.ArraysAndStrings.SystemDesign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    private Set<Integer> generatedNumbers;
    private final int rangeStart;
    private final int rangeEnd;
    private final Random random;
    private List<Integer> shuffledList;
    private int currentIndex;

    // Constructor for HashSet approach
    public RandomNumberGenerator(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.generatedNumbers = new HashSet<>();
        this.random = new Random();
    }

    // Constructor for ArrayList approach
    public RandomNumberGenerator(int rangeStart, int rangeEnd, boolean useShuffle) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.random = new Random();
        this.currentIndex = 0;
        if (useShuffle) {
            this.shuffledList = new ArrayList<>();
            for (int i = rangeStart; i <= rangeEnd; i++) {
                shuffledList.add(i);
            }
            Collections.shuffle(shuffledList, random);
        }
    }

    // Method for HashSet approach
    public int nextRandom() {
        if (generatedNumbers.size() == (rangeEnd - rangeStart + 1)) {
            throw new IllegalStateException("All numbers in the range have been generated.");
        }
        int randomNumber = 0;
        while (generatedNumbers.contains(randomNumber)) {
            randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
        }
        generatedNumbers.add(randomNumber);
        return randomNumber;
    }

    // Method for ArrayList approach
    public int nextRandomShuffle() {
        if (shuffledList == null) {
            throw new IllegalStateException("ArrayList approach not initialized.");
        }
        if (currentIndex >= shuffledList.size()) {
            throw new IllegalStateException("All numbers in the range have been generated.");
        }
        return shuffledList.get(currentIndex++);
    }

    public static void main(String[] args) {
        // Using HashSet approach
        RandomNumberGenerator generator = new RandomNumberGenerator(1, 10);
        System.out.print("Using HashSet approach: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(generator.nextRandom() + " ");
        }
        System.out.println("");
        // Using ArrayList approach
        RandomNumberGenerator generator2 = new RandomNumberGenerator(1, 10, true);
        System.out.print("Using ArrayList approach: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(generator2.nextRandomShuffle() + " ");
        }
    }
}