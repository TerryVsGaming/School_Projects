import java.util.Scanner;
public class Hw3Q2 {
    public static int bin2Dec(String binaryString) {
        int intValue = Integer.parseInt(binaryString);
        int decimal = 0;
        int b = 0;

        for (int n = 0; n <= binaryString.length() - 1; n++) {

            decimal += (intValue % 10) * Math.pow(2, b);
            b++;
            intValue /= 10;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Insert the Binary Value: ");
        String binary = sc.nextLine();
        System.out.print("The Decimal Equivalent of " + binary + " is " + bin2Dec(binary));
    }
}
