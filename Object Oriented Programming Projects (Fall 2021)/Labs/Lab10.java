import java.util.Scanner;
public class Lab10 {

    public static void main (String [] args){
        //Part 1
        System.out.println("Part 1" + "\n");

     Scanner sc = new Scanner (System.in);

     System.out.println("Please Insert your Phone Number: ");
     String phoneNumber = sc.nextLine();

     if (phoneNumber.length() == 10){
         System.out.println( "Formed Phone Number: (" + phoneNumber.substring(0,3) + ")" + phoneNumber.substring(3,6)
                 + "-" + phoneNumber.substring(6, 10));
     }

     else {
         System.out.println("Invalid Input");
     }


        //Part 2
        int counter = 0;
        System.out.println("Part 2" + "\n");

        System.out.println("Please Insert a Social Security Number: ");
        String SSN = sc.nextLine();



     if (SSN.length() == 11 && SSN.substring(3,4).equals ("-") && SSN.substring(6,7).equals("-")) {
         if (SSN.substring(0, 3).contains("-") || SSN.substring(4, 6).contains("-") || SSN.substring(7).contains("-")) {
             System.out.println(SSN + " is NOT A Valid Social Security Number");
         } else {
             System.out.println(SSN + " is A Valid Social Security Number: ");

         }
     }

     else{
         System.out.println(SSN + " is NOT A Valid Social Security Number");
     }
    }
}
