import java.util.Scanner;

public class Lab16pt2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert the Number: ");
        int n = sc.nextInt();

        int[] array = new int[101];

        for (int index = 0; index < 101; index++) {
            if (n == 0) {
                break;
            }

            array[n - 1] ++;
            n = sc.nextInt();
        }

        int a = 0;

        for (n = 0; n < array.length; n++){
            if (array[n] != 0) {
                System.out.println((n + 1) + " was seen " + array[n] + " times ");
            }

            }





    }
}



