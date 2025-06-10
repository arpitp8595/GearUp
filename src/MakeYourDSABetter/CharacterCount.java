package src.MakeYourDSABetter;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

    public static void main(String[] args) {
        String str = "i like leetcode";
        System.out.println("All Characters with count: ");
        getCharacterCount(str);
    }

    public static void getCharacterCount(String string) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch :string.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
            System.out.println("Key: "+entrySet.getKey()+" and Value: "+entrySet.getValue());
        }
    }

}
