import java.util.Scanner;
public class Lab15 {

    public static double mean(double[] x) {
        int n = x.length;
        double sum = 0;
        double avg = 0;


        for (int index = 0; index < n; index++) {
            sum += x[index];
        }

        avg = sum / n;

        return avg;
    }


    public static double deviation(double[] x) {

        int n = x.length;
        double sum2 = 0;
        double inside = 0;

        for (int index2 = 0; index2 < n; index2++) {
            inside += Math.pow(x[index2] - mean(x), 2);

        }

        double stddev = Math.pow((inside) / (n - 1), 0.5);

        return stddev;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        double[] array1 = new double[10];

        System.out.print("Enter the 10 Numbers: ");
        for (int index = 0; index < array1.length; index++) {
            array1[index] = sc.nextDouble();
        }

        System.out.println("mean: " + mean(array1) + " stddev: " + deviation(array1));
    }


}





