package CTCI.java.Chapter01_Arrays_Strings.stringCompression;

public class Solution {
    public static void main(String[] args){
        System.out.println(compressString("aabcccccaaa")); //a2b1c5a3
        System.out.println(compressString("aaabb")); //a3b2
        System.out.println(compressString("ab")); //ab
        System.out.println(compressString("a")); //a
    }

    public static String compressString(String str){
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder compStr = new StringBuilder();
        String ans;
        int currFreq = 1;
        for (int i=1; i<str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)){
                currFreq++;
            }else{
                compStr = compStr.append(str.charAt(i-1)).append(currFreq);
                currFreq = 1;
            }
        }
        compStr = compStr.append(str.charAt(str.length()-1)).append(currFreq);
        ans = compStr.toString();
        if (str.length() <= ans.length()){
            return str;
        }
        return ans;
    }
}