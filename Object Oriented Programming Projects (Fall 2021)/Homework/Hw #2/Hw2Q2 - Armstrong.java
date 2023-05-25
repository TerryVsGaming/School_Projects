import java.util.Scanner;


public class Armstrong {

    public static void main(String[] args) {
        int lowerLimit, upperLimit;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lower limit: ");
        lowerLimit = sc.nextInt();
        System.out.print("Enter upper limit: ");
        upperLimit = sc.nextInt();
        System.out.print("The Armstrong numbers between " + lowerLimit + " and " + upperLimit + " are: ");
        for(int number = lowerLimit; number <= upperLimit; number++)
        {
            int numberOfDigits = 0;
            int powerSum = 0;
            int numberCopy = number;
            while(numberCopy > 0)
            {
                numberCopy /= 10;
                numberOfDigits++;
            }
            numberCopy = number;
            while(numberCopy > 0)
            {
                int digit = numberCopy % 10;
                powerSum += Math.pow(digit, numberOfDigits);
                numberCopy /= 10;
            }
            if(powerSum == number)
            {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}