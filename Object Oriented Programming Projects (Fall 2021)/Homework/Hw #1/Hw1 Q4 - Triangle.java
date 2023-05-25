import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please Input Side 1: ");
        double Side1 = sc.nextDouble();
        System.out.print("Please Input Side 2: ");
        double Side2 = sc.nextDouble();
        System.out.print("Please Input Side 3: ");
        double Side3 = sc.nextDouble();


        if(Side1 + Side2 < Side3 || Side1 + Side3 < Side2 || Side2 + Side3 < Side1){
            System.out.print("Invalid Input! :( ");
            System.exit(0);
        }


        while (Side1 + Side2 > Side3 || Side1 + Side3 > Side2 || Side2 + Side3 > Side1) {
            if (Side1 == Side2 && Side2 == Side3) {
                System.out.print("This Triangle is Equilateral");
                System.exit(0);
            }

            else if (Side1 == Side2 && (Side2 != Side3 && Side1 != Side3)
                    || Side2 == Side3 && (Side3 != Side1 && Side2 != Side1)
                    || Side1 == Side3 && (Side1 != Side2 && Side3 != Side2)) {
                System.out.print("This Triangle is Isosceles");
                System.exit(0);
            }

            else if (Side1 != Side2 && Side2 != Side3 && Side3 != Side1) {
                System.out.print("This Triangle Is Scalene");
                System.exit(0);
            }

        }


    }
}









