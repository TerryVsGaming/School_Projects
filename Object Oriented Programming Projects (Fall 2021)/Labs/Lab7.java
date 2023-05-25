import java.util.Scanner;
public class Lab7 {
    public static void main (String[] args){

//part 1
        System.out.println("Part 1" + "\n");

        Scanner sc = new Scanner (System.in);
        System.out.print("x coordinate: ");
        double yourX = sc.nextDouble();
        System.out.print("y coordinate: ");
        double yourY = sc.nextDouble();

        double xCenter = 0;
        double yCenter = 0;

        double insideLeft = Math.pow(yourX - xCenter, 2);
        double insideRight = Math.pow(yourY - yCenter, 2);

        double distance = Math.pow( (insideLeft + insideRight), 0.5);

        if(distance >= 0 && distance <= 10){
            System.out.print("Coordinates ( " + yourX + ", " + yourY + " ) are in The Circle");
        }

        else {
            System.out.print("These Coordinates are not in the Circle");
        }


        //part 2
        System.out.print("\n");
        System.out.println("\n" + "Part 2" + "\n");


        System.out.print("Please Insert the Number of Sides: ");
        double  numberOfSides = sc.nextDouble();

        System.out.print("Please Insert the Length of the Side: ");
        double lengthOfSides = sc.nextDouble();

        double Area = ( numberOfSides * Math.pow(lengthOfSides, 2) ) / (4 * Math.tan(Math.PI/numberOfSides) );

        System.out.print("Area: " + Area);

    }

}
