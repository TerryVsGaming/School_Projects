import java.util.Scanner;

public class Lab5 {
    public static void main (String [] args){

        //Part 1
        System.out.println("Part 1" + "\n");

        Scanner sc = new Scanner (System.in);

        System.out.print("Please insert the A value: ");
        double aValue = sc.nextDouble();
        System.out.print("Please insert the B value: ");
        double bValue = sc.nextDouble();
        System.out.print("Please insert the C value: ");
        double cValue = sc.nextDouble();

        double r1 = (-bValue + Math.pow( (Math.pow(bValue,2) -4*aValue*cValue), 0.5) ) /2*aValue;
        double r2 = (-bValue - Math.pow( (Math.pow(bValue,2) -4*aValue*cValue), 0.5) ) /2*aValue;


        if(Math.pow(bValue,2) - 4 * aValue * cValue > 0){
            System.out.println("The Equation Has Two Roots: " + r1 + " and " + r2);
        }

        else if (Math.pow(bValue,2) - 4 * aValue * cValue == 0){
            System.out.println("The Equation Has One Root: " + r1);
        }

        else{
            System.out.println("The Equation Has NO Real Roots");
        }


        System.out.println("\n");

        //Part 2
        System.out.println("Part 2" + "\n");
        double costOfShipping;

        System.out.print("Please Insert the Weight of the Package: ");
        double weightOfPackage = sc.nextDouble();

        if(0 > weightOfPackage){
            System.out.println("Invalid Input");
        }

        else if (0 < weightOfPackage && weightOfPackage <= 1){
            costOfShipping = 3.5;
            System.out.print("The cost of shipping for a package of " + weightOfPackage + " pounds is $" +
            costOfShipping);
        }

        else if (1 < weightOfPackage && weightOfPackage <= 3){
            costOfShipping = 5.5;
            System.out.print("The cost of shipping for a package of " + weightOfPackage + " pounds is $" +
                    costOfShipping);
        }

        else if (8.5 < weightOfPackage && weightOfPackage <= 10){
            costOfShipping = 8.5;
            System.out.print("The cost of shipping for a package of " + weightOfPackage + " pounds is $" +
                    costOfShipping);
        }

        else if (10 < weightOfPackage && weightOfPackage <= 20){
            costOfShipping = 10.5;
            System.out.print("The cost of shipping for a package of " + weightOfPackage + " pounds is $" +
                    costOfShipping);
        }
        else{
            System.out.println("The package cannot be shipped");
        }

    }
}
