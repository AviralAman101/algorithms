package in.algo;

import java.util.Arrays;
import java.util.HashMap;

public class UnusualStringSort {
    public static void main(String[] args) {
        System.out.println(stringSort("bAwutndekWEdkd"));
    }//AbEdWddekkntuw

    public static String stringSort (String s)
    {
        //Counting Sort
        int[] sm = new int[26];
        int[] lg = new int[26];
        String sf="";

        int l = s.length();
        for (int i = 0; i < l; i++) {
            int c = s.charAt(i);
            if(c>96){
                sm[c-97]=sm[c-97]+1;
            }else
                lg[c-65]=lg[c-65]+1;
        }
        boolean hasSm=sm.length>0;
        boolean hasLg=lg.length>0;
        Character te;
        while (sf.length()<l){
            Character lgC = getChar(lg);
            Character smC = getChar(sm);

        }
        return null;
    }

    static Character getChar(int[] sm){
        for (int i = 0; i < sm.length; i++) {
            if(sm[i] !=0){
                for (int j = 0; j < sm[i]; j++) {
                    return ((char)(i+97));
                }
            }
        }
        return null;
    }
}
