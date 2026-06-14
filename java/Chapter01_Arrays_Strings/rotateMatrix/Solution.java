package CTCI.java.Chapter01_Arrays_Strings.rotateMatrix;

public class Solution {
    public static void main(String[] args){
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13,14, 15,16}
        };

        //int[][] matrix1 = copyMatrix(matrix);
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateMatrix(matrix);
        System.out.println("After Rotation (Transpose + Reverse):");
        printMatrix(matrix);
    }

    public static int[][] copyMatrix(int[][] matrix){
        int n = matrix.length;
        int[][] matrix1 = new int[n][n];
        for (int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                matrix1[i][j] = matrix[i][j];
            }
        }
        return matrix1;
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

    public static void rotateMatrix(int[][] matrix){
        int n = matrix.length;
        transposeMatrix(matrix, n);
        for(int i=0; i<n; i++){
            reverseRow(matrix[i]);
        }
    }

    public static void transposeMatrix(int[][] matrix, int n){
        int temp = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseRow(int[] row){
        int i=0, j=row.length-1, temp=0;
        while(i<j){
            temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }
}
