package CTCI.java.Chapter01_Arrays_Strings.isUnique;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        //Approach 1 : Store elements in a map and check if the element exists

        System.out.println(isUnique("TesT"));

        //Approach 2 : Sort and check the next adjacent element is same
        System.out.println(isUniqueWithoutExtraSpace("TestaT"));
    }

    public static boolean isUnique(String s){
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        for (Character ch: s.toCharArray()){
            if (map.containsKey(ch)){
                return false;
            }
            map.put(ch, true);
        }
        return true;
    }

    public static boolean isUniqueWithoutExtraSpace(String s){
        char[] charr = s.toCharArray();
        Arrays.sort(charr);
        for (int i = 0; i < charr.length - 1; i++){
            if (charr[i] == charr[i+1]){
                return false;
            }
        }
        return true;
    }
}
