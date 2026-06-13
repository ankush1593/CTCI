package CTCI.java.Chapter01_Arrays_Strings.checkPermutation;

import java.util.HashMap;

public class Solution {
    public static void main (String[] args){
        System.out.println(checkPermutation("abcd", "bcda"));
    }

    public static boolean checkPermutation(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character ch : s1.toCharArray()){
            int value = 0;
            if (map.containsKey(ch)){
                value = map.get(ch);
            }
            value++;
            map.put(ch, value);
        }

        for (Character ch : s2.toCharArray()){
            int count = 0;
            if (map.containsKey(ch)){
                map.get(ch);
            }
            count--;
            if (count < 0){
                return false;
            }
        }
        return true;
    }
}
