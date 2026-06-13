package CTCI.java.Chapter01_Arrays_Strings.URLify;

public class Solution {

    public static void main(String[] args) {

        String input = "Mr John Smith    ";
        int trueLength = 13;

        char[] str = input.toCharArray();
        replaceSpaces(str, trueLength);

        System.out.println(new String(str)); 
    }

    public static void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0;

        for (int i = 0; i<trueLength; i++){
            if (str[i] == ' '){
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount*2 -1;

        for (int i = trueLength-1; i >=0; i--){
            if (str[i] == ' '){
                str[index] = '0';
                str[index-1] = '2';
                str[index-2] = '%';
                index = index - 3;
            }else{
                str[index] = str[i];
                index--;
            }
        }
    }
}
