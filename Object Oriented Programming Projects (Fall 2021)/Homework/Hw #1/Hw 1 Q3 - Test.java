import java.util.Scanner;
public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please insert an integer of your choice: ");
        int Integer = sc.nextInt();


        if(Integer % 5 == 0 && Integer % 6 == 0){
            System.out.println(Integer + " Is Divisible by Both 5 and 6");
        }

        if(Integer % 5 == 0 || Integer % 6 == 0){
            System.out.println(Integer + " Is Divisible by Either 5 or 6 (or possibly both)");
        }

        if(Integer % 5 == 0 ^ Integer % 6 == 0){
            System.out.println(Integer + " Is Divisible by Either 5 or 6 But Not Both");
        }

        if(Integer % 5 != 0 && Integer % 6 != 0){
            System.out.println(Integer + " Is Not Divisible by Neither 5 nor 6");
        }




    }

}

