// Create 2-dimensional arrays (i and j specified by user) 10/27/2021

import java.util.Scanner;
public class Matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Please Insert the Number of Rows: ");
        int row = sc.nextInt();
        System.out.print("Please Insert the Number of Columns: ");
        int col = sc.nextInt();


        int[][] matrix = new int [row][col];

        for (row = 0; row < matrix.length; row++) {
            for (col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (int) (Math.random() * 1000);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }
}
