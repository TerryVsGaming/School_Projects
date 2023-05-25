import java.util.Scanner;

public class Lab4 {
    public static void main (String [] args){


        //part 1
        System.out.println("Part 1");

        Scanner sc = new Scanner (System.in);

        System.out.print("Please Insert Your Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Please Insert the Annual Interest Rate: %" );
        double anualInterestRate = sc.nextDouble();


        double interest = balance * (anualInterestRate / 120);

        System.out.print("The Interest is: " + interest);
        System.out.println();
        System.out.println();

//Part 2
        System.out.println("part 2");


        System.out.print("Please Insert Your x1: ");
        double x1 = sc.nextDouble();

        System.out.print("Please Insert Your y1: ");
        double y1 = sc.nextDouble();

        System.out.print("Please Insert Your x2: ");
        double x2 = sc.nextDouble();

        System.out.print("Please Insert Your y2: ");
        double y2 = sc.nextDouble();

        double insideLeft = Math.pow((x2 - x1), 2);
        double insideRight = Math.pow((y2 - y1), 2);

        double distance = Math.pow((insideLeft + insideRight), 0.5);

        System.out.print("The Distance Between (x1, y1) and (x2, y2) is: " + distance);


    }
}

