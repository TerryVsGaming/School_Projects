import java.util.Scanner;

public class Lab14 {

    public static double area(double side) {
        double inside = Math.toRadians(36);
        double area = (5 * Math.pow(side, 2) / (4 * Math.tan(inside)));
        return area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert the length of a side of the pentagon: ");
        double side = sc.nextDouble();

        System.out.print("The area of a pentagon with a side length " + side + " is: " + area(side));
    }
}


