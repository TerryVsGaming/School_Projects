import java.util.Scanner;

public class Lab2 {
    public static void main (String[] args){


        //Part 1
        final double PI = 3.1415;
        double radius = 5.5;

        double perimeter = 2*radius*PI;
        double area = radius*radius*PI;

        System.out.println("perimeter = " + perimeter);
        System.out.println("area = " + area);


        //Part 2
        Scanner sc = new Scanner (System.in);
        double v0;
        double v1;
        double time;


        System.out.print("Please input your v0: ");
        v0 = sc.nextDouble();
        System.out.print("Please input your v1: ");
        v1 = sc.nextDouble();
        System.out.print("Please input the time: ");
        time = sc.nextDouble();

        double averageAcceleration = (v1-v0)/time;

        System.out.println("Average Acceleration = " + averageAcceleration);




    }
}
