import java.util.Scanner;

public class perfectNumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int upperLimit = 0;
        System.out.print("Enter an upper limit: ");
        upperLimit = sc.nextInt();
        System.out.print("The perfect numbers below " + upperLimit + " are: ");

        for(int number = 1; number < upperLimit; number++)
        {
            int sum = 0; // sum of divisors
            for(int divisor = 1; divisor < number; divisor++)
            {
                if(number % divisor == 0)
                {
                    sum += divisor;
                }
            }
            if(sum == number)
            {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
