import java.util.*;

public class Homework2 {

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);


        double[] myGrades = new double [5];
        String yourName = "";

        System.out.print("Your Name: ");
        yourName = sc.nextLine();

        double total = 0;



        for (int i = 0; i < myGrades.length; i++){
            System.out.print("Grade #" + (i+1) + ": ");
            myGrades[i] = sc.nextDouble();
            total += myGrades[i];

            if (i == myGrades.length - 1){
                System.out.print("Average: " + (total / myGrades.length));
            }


        }






    }


}
