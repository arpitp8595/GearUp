package src.SomeFamousAlgo;

import java.util.ArrayList;
import java.util.List;

//Fidelity: senior software developer position, 1/6/2025
public class JosephusProblem {

    public static void main(String[] args) {
        // Example usage
        List<String> alphabets = List.of("A", "B", "C", "D", "E", "F", "G");
        int start = 2; // Starting at index 2 ("C")
        int jump = 3;  // Jump 3 steps each time

        String lastElement = findLastElement(alphabets, start, jump);
        System.out.println("The last remaining element is: " + lastElement);
    }

    public static String findLastElement(List<String> list, int start, int jump) {
        // Validate input
        if (list == null || list.isEmpty()) {
            return "";
        }
        if (start < 0 || start >= list.size()) {
            return "Start can not be less than or equal to zero.";
        }
        if (jump <= 0) {
            return "Jump can not be less than or equal to zero.";
        }

        // Create a copy of the list to avoid modifying the original list
        List<String> elements = new ArrayList<>(list);

        // Initialize the current position
        int current = start;

        // Continue until only one element remains
        while (elements.size() > 1) {
            // Calculate the index of the element to remove
            current = (current + jump) % elements.size();

            // Remove the element at the calculated index
            elements.remove(current);
        }

        // Return the last remaining element
        return elements.get(0);
    }
}
