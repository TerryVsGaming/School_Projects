import java.util.Scanner;
public class Hw3Q1 {
    public static String dec2Bin(int decimal) {
        String binary = "";
        String binarycopy = "";


        while (decimal >= 1) {
            binarycopy += decimal % 2;
            decimal /= 2;
        }

        for (int index = binarycopy.length() - 1; index >= 0; index--) {
            binary += binarycopy.charAt(index);
        }
        return binary;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Insert the Decimal Value: ");
        int input = sc.nextInt();
        System.out.print("Binary Value of " + input + ": " + dec2Bin(input));
    }
}
