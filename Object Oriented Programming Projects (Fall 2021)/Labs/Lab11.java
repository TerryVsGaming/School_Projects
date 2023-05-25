import java.util.Scanner;
public class Lab11 {
    public static void main(String[] args) {






            double division;
            double sum = 0;
            int counter = 0;

            for (double i = 1, j = 3; i <= 97 && j <= 99; i += 2, j += 2) {
                division = i / j;
                sum += division;
                counter++;


            }
            System.out.println(sum);













    }
}