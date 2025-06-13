package src.ArraysAndStrings.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public static void main(String[] args) {
        String str = "aaaabbbccdddddd";
        System.out.println("Reorganized String: "+reorganizeString(str));
    }

    private static String reorganizeString(String str) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b)-freqMap.get(a));

        maxHeap.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();

        while (maxHeap.size()>=2) {
            char firstElement = maxHeap.poll();
            char secondElement = maxHeap.poll();

            sb.append(firstElement);
            sb.append(secondElement);

            freqMap.put(firstElement, freqMap.getOrDefault(firstElement,0)-1);
            freqMap.put(secondElement, freqMap.getOrDefault(secondElement,0)-1);

            if (freqMap.get(firstElement) > 0) {
                maxHeap.offer(firstElement);
            }
            if (freqMap.get(secondElement) > 0) {
                maxHeap.offer(secondElement);
            }
        }
        if (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            if (freqMap.get(ch)>1)
                return "";
            sb.append(ch);
        }

        return sb.toString();
    }


    //All outputs are accepted
    //dadadbdbacdcadb : regular method
    //dadadbdbdbdcaca : method with 1
    //dadadbdbdbdcaca : leetcode method

    public static String reorganizeString1(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}
