import java.util.Arrays;
import java.util.Scanner;

public class Lab15pt2 {

    public static void swap(double[] array, int index1, int index2) {

        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }


    public static void reverse(double[] x) {
        if (x.length <= 1) {
            return;
        }


        int index1 = 0;
        int index2 = x.length - 1;


        while (index1 < index2) {
            swap(x, index1, index2);
            index1++;
            index2--;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double array[] = new double[10];

        System.out.println("Insert the inside of the Array: ");
        for (int index = 0; index < array.length; index++) {

            array[index] = sc.nextDouble();
        }

        System.out.println("Original: " + Arrays.toString(array));

        reverse(array);
        System.out.println("Reverse: " + Arrays.toString(array));
    }

}
