import java.util.Scanner;
public class Lab13pt2 {

    public static void reverse(int number){
    String stringNumber = String.valueOf(number);
String backwards = "";

    for (int index = stringNumber.length()-1; index >= 0; index--){
        backwards += stringNumber.charAt(index);
    }

        int intValue = Integer.parseInt(backwards);
        System.out.print(intValue);

    }


    public static void main (String [] args){
Scanner sc = new Scanner (System.in);
        System.out.print("Please Insert a Number: ");
int inputNumber = sc.nextInt();
System.out.print("Reverse: ");
        reverse(inputNumber);
    }



}
