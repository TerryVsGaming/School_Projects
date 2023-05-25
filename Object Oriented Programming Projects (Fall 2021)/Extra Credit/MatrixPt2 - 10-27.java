// Create 2-dimensional arrays (i and j created using random) - 10/27/2021


import java.util.Scanner;

public class matrixPt2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = (int) (Math.random() * 10);
        System.out.println(row + " rows");
        int col = (int) (Math.random() * 10);
        System.out.println(col + " columns");


        int[][] matrix = new int[row][col];

        System.out.print("Matrix: " + "\n");
        for (row = 0; row < matrix.length; row++) {
            for (col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (int) (Math.random() * 1000);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

