import java.util.Scanner;

public class Lab6 {
public static void main (String [] args){

    //Part 1
    System.out.println("Part 1" + "\n");
   Scanner sc = new Scanner (System.in);
    System.out.print("Please Insert your Integer: ");
    int Integer = sc.nextInt();

    int firstDigitReverse = Integer /100;
    int finalDigitReverse = Integer % 10;

    if(firstDigitReverse == finalDigitReverse){
        System.out.println(Integer + " is a Palindrome!");
    }

    else{
        System.out.println(Integer + " is NOT a Palindrome");
    }

    //Part 2
    System.out.println("Part 2" + "\n");

    System.out.print("Please Insert the Driving Distance: ");
    double drivingDistance = sc.nextDouble();

    System.out.print("Please Insert the Miles per Gallon: ");
    double milesPerGallon = sc.nextDouble();

    System.out.print("Please Insert the Price per Gallon: ");
    double pricePerGallon = sc.nextDouble();

    double totalCostofTrip = (drivingDistance/milesPerGallon) * pricePerGallon;

    System.out.println("Total Cost of the Trip is " + totalCostofTrip);

 }
}
