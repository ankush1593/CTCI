package CTCI.java.Chapter01_Arrays_Strings.PalindromePermutation;

public class Solution {
    public static void main(String[] args){
        System.out.println(checkPalindrome("Tact Coa"));
    }

    public static boolean checkPalindrome(String str){
        int[] freq = new int[128];
        for (char ch : str.toCharArray()){
            if (ch != ' '){
                ch = Character.toLowerCase(ch);
                freq[ch - 'a']++;
            }
        }

        boolean isOddFound = false;
        
        for (int count : freq){
            // Here we can also maintain an oddCount and check if oddCount <=1 if not return false.
            if (count % 2 == 1){
                if (isOddFound){
                    return false;
                }
                isOddFound = true;
            }
        }
        return true;
    }
}
