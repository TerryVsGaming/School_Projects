import java.util.Scanner;
public class Temperature {
    public static void main (String [] args){

        Scanner sc = new Scanner (System.in);

        System.out.print("Please insert the outside temperature (must be between -58 and +41 degrees Fahrenheit): ");
        double outsideTemperature = sc.nextDouble();

        System.out.print("Please insert the wind speed (must be greater or equal to 2 mph): ");
        double Velocity = sc.nextDouble();


        if (outsideTemperature>= -58 && outsideTemperature <= 41 && Velocity >= 2) {

            double windChillTemperature = 35.74 + (0.6215 * outsideTemperature) -
                        (35.75 * (Math.pow(Velocity, 0.16))) + (0.4275 * outsideTemperature * (Math.pow(Velocity, 0.16)));

            //System.out.print("The Wind Chill Temperature is approximately: " + windChillTemperature); <-- exact
            System.out.print("The Wind Chill Temperature is approximately: " + Math.round(windChillTemperature * 100.00) / 100.00 + " degrees Fahrenheit"); // <-- estimation

            }

        else {

        System.out.println("Invalid Outside Temperature and/or Wind Speed");

        }



     }
}
