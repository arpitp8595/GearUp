package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] array = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        getGroupAnagram2(array);

    }

    private static void getGroupAnagram(String[] array) {

        Map<String, List<String>> map = new HashMap<>();
        for (String s : array) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str  = new String(chars);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        for (List<String> list : map.values()) {
            System.out.println(list);
        }
    }

    private static void getGroupAnagram2(String[] array) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: array) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        for (List<String> list : map.values()) {
            System.out.println(list);
        }

    }
}