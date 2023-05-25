import java.util.Arrays;
import java.util.Scanner;

/**
 * Array Extra Credit (10/18/2021)
 * Extra Credit:
 * Generate 120 scores with min score being 20 and max being 95
 * # students = 120
 * Avg = ?
 * # students with grade greater than avg = ?
 * Score >= 90 = A → how many A’s?
 * → Using Array
 */

public class ArrayExtraCredit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] array = new double[120];

        for (int i = 0; i < array.length; i++) {
            array[i] = 20 + (int) (Math.random() * 76);
        }

        double sum = 0;
        for (int index = 0; index < array.length; index++) {
            sum += array[index];
        }

        double avg = sum / array.length;

        double greaterThanAvgCounter = 0;
        double aCounter = 0;

        for (int index2 = 0; index2 < array.length; index2++) {
            if (array[index2] > avg) {
                greaterThanAvgCounter++;
            }

            if (array[index2] >= 90) {
                aCounter++;
            }
        }


        System.out.println(Arrays.toString(array));
        System.out.println("Average: " + avg);
        System.out.println("Number of People Who Did Better Than Average: " + greaterThanAvgCounter);
        System.out.println("Number of People Who Got an A: " + aCounter);

    }

}
