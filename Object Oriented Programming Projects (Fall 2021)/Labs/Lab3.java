import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {

        //Part 1
        System.out.println("Part 1");
        Scanner sc = new Scanner(System.in);

        System.out.print("Please Enter a Degree in Celsius: ");
        double Celsius = sc.nextDouble();

        double Fahrenheit = (1.8 * Celsius) + 32;

        System.out.println(Celsius + " Degrees Celsius is " + Fahrenheit + " Degrees Fahrenheit");


        System.out.println();


        System.out.println("Part 2");
        //Part 2

        System.out.print("Please insert the weight of the water in KG: ");
        double M = sc.nextDouble(); // weight of water in KG
        System.out.print("Please insert the final temperature of the water: ");
        double finalTemperature = sc.nextDouble();
        System.out.print("Please insert the initial temperature of the water: ");
        double initialTemperature = sc.nextDouble();

        double Q = M * (finalTemperature - initialTemperature) * 4184;

        System.out.print("The Energy Needed To Heat the Water from this initial temperature " +
                "to this final temperature is " + Q + " Joules");

    }
}
