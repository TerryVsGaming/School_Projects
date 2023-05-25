import java.util.Scanner;

public class Hw4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please Submit Your First Number: ");
        double firstNumber = sc.nextDouble();
        System.out.print("Please Submit Your Second Number: ");
        double secondNumber = sc.nextDouble();
        sc.nextLine();




        System.out.print("Please Choose an Operation (add, subtract, multiply, or divide): ");
        String operation = sc.nextLine();



        if (operation.equals("add")){
            System.out.println("The Sum of Your Numbers is: " + add(firstNumber, secondNumber));
        }

        else if (operation.equals("subtract")){
            System.out.println("The Difference of Your Numbers is: " + subtract(firstNumber, secondNumber));
        }

       else if (operation.equals("multiply")){
            System.out.println("The Product of Your Numbers is: " + multiply(firstNumber, secondNumber));
        }

       else if (operation.equals("divide")){
            System.out.println("The Quotient of Your Numbers is: " + divide(firstNumber, secondNumber));
        }

       else{
           System.out.println("Invalid Operation");
        }
    }

    public static double add (double numberOne, double numberTwo){
        return numberOne + numberTwo;
    }

    public static double subtract (double numberOne, double numberTwo){
        return numberOne - numberTwo;
    }

    public static double multiply (double numberOne, double numberTwo){
        return numberOne * numberTwo;
    }

    public static double divide (double numberOne, double numberTwo){
        return numberOne / numberTwo;
    }

}


