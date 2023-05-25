import java.util.Scanner;

public class Lab16 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please Insert the Number of Students: ");
        int n = sc.nextInt();

        double[] array = new double[n];
        double[] arrayCopy = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Insert " + (i + 1) + " student's grade: ");
            array[i] = sc.nextDouble();
            arrayCopy[i] = array[i];
        }


        bubbleSort(arrayCopy);
        double max = arrayCopy[arrayCopy.length - 1];

        char grade;
        for (int index = 0; index < array.length; index++) {
            if (array[index] >= max - 10) {
                grade = 'A';
            } else if (array[index] >= max - 20 && array[index] < max - 10) {
                grade = 'B';
            } else if (array[index] >= max - 30 && array[index] < max - 20) {
                grade = 'C';
            } else if (array[index] >= max - 40 && array[index] < max - 30) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Student " + index + " got a score of " + array[index] + " which is a " + grade);
        }


    }

    public static double[] bubbleSort (double[] data) {
        double temp;
        for (int a = 0; a < data.length; a++) {
            for (int b = 0; b < data.length - 1; b++) {
                if (data[b] > data[b + 1]) {
                    temp = data[b];
                    data[b] = data[b + 1];
                    data[b + 1] = temp;
                }
            }
        }
        return data;
    }


}
