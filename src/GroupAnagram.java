import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] array = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        getGroupAnagram(array);

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
}