import java.util.*;

public class Homework1 {

    public static void main(String[] args){

   double value = 0;
   double value2 = 0;

   Scanner sc = new Scanner (System.in);
   System.out.print("Please enter your first value:");
   value = sc.nextDouble();
   sc.nextLine();

   System.out.print("Please enter your second value:");
   value2 = sc.nextDouble();
   sc.nextLine();

   String operation = "";
   System.out.print("Please enter a mathematical operation:");
   operation = sc.nextLine();


if (operation.equals("add")){
    System.out.print("result: " + "" + (value + value2));
}

else if (operation.equals("subtract")){
    System.out.print("result: " + "" + (value - value2));
}

else if (operation.equals("multiply")){
    System.out.print("result: " + "" + (value * value2));
}

else if (operation.equals("divide")){
    System.out.print("result: " + "" + (value / value2));
}

else{
    System.out.print("Invalid Operation");
}



    }
}
