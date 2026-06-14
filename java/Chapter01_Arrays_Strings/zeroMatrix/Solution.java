package CTCI.java.Chapter01_Arrays_Strings.zeroMatrix;

import java.util.HashSet;

public class Solution {
        public static void main(String[] args){
            int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
            };
            setZeroMatrix(matrix);
            printMatrix(matrix);
        }

        public static void setZeroMatrix(int[][] matrix){
            int m = matrix.length;
            int n = matrix[0].length;
            HashSet<Integer> rows = new HashSet<Integer>();
            HashSet<Integer> cols = new HashSet<Integer>();

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if (matrix[i][j] == 0){
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if (rows.contains(i) || cols.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        public static void printMatrix(int[][] matrix){
            for(int[] row: matrix){
                for (int val: row){
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

}
