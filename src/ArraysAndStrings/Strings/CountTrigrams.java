package src.ArraysAndStrings.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTrigrams {
    public static void main(String[] args) {
        String str = "She sells seashells by the seashore&quot";
        System.out.println("---List of trigrams---");
        countTotalTrigrams(str);
    }

    private static void countTotalTrigrams(String str) {
        String cleanText = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Map<String, Integer> map  = new HashMap<>();

        if (str.length() < 3) {
            System.out.println("No Valid Trigrams.");
        }

        for (int i=0; i<cleanText.length()-3; i++) {
            String trigram = cleanText.substring(i, i+3);
            map.put(trigram, map.getOrDefault(trigram, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry: sortedList){
            System.out.println("Key: "+entry.getKey()+ " & Value: "+entry.getValue());
        }

    }
}
