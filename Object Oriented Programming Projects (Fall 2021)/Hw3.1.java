import java.util.*;

public class Hw3 {

   public static void main (String [] args){
Scanner sc = new Scanner(System.in);

System.out.print("Please pick a number: ");
int pickedNumber = sc.nextInt();
int i = 0;

      if (pickedNumber < 0){
         System.out.println("Illegal Input");
      }
    else {

while (pickedNumber >= 1) {
    pickedNumber /= 2;
    i++;
}

}


   System.out.println("Your Number Is Divisible by 2: " + i + " times before it becomes strictly less than one");








   }




}
