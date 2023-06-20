package in.algo;

import java.util.HashMap;

public class Anagaram {
    public static void main(String[] args) {
        System.out.println("Test::");
        System.out.println("Check if strings adda and daad are anagrams");
        System.out.println(isAnagram("daad", "adda"));
    }
    public static boolean isAnagram(String a,String b)
    {
        if(a.length() != b.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char key = a.charAt(i);
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else map.put(key,1);
        }
        for (int i = 0; i < a.length(); i++) {
            char key = b.charAt(i);
            if(map.containsKey(key)){
                Integer integer = map.get(key);
                if(integer > 0){
                    map.put(key,--integer);
                }else return false;
            }else return false;
        }
        return true;
    }

}
