package CTCI.java.Chapter01_Arrays_Strings.oneAway;

public class Solution {
    public static void main(String[] args){
        System.out.println(oneEditAway("pale", "ple"));   // true
        System.out.println(oneEditAway("pales", "pale")); // true
        System.out.println(oneEditAway("pale", "bale"));  // true
        System.out.println(oneEditAway("pale", "bake"));  // false
    }

    public static boolean oneEditAway(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();

        if (Math.abs(l2 - l1) > 1){
            return false;
        }

        if (l1 == l2){
            return oneEditReplace(s1,s2);
        }else if (l1 + 1 == l2){
            return oneEditInsert(s1, s2);
        }else if (l1 - 1 == l2){
            return oneEditInsert(s2, s1);
        }
        return false;
    }

    public static boolean oneEditReplace(String s1, String s2){
        int diffCount = 0;
        for (int i=0; i<s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                if (diffCount >= 1){
                    return false;
                }
                diffCount++;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2){
        int i=0,j=0,diffCount=0;
        while (i<s1.length() && j<s2.length()){
            if (s1.charAt(i) != s2.charAt(j)){
                if (diffCount >= 1){
                    return false;
                }
                diffCount++;
                j++;
            }else{
                i++;
                j++;
            }
        }
        return true;
    }

}