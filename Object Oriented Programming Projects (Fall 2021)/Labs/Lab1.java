/*
Terry (Terrence) Shvartsman
CSE 114
Lab #1
8/31/2021
*/


import java.util.Scanner;

public class Lab1 {
    public static void main (String [] args){

        double radius; // declares radius
        double area; // declares area

        System.out.print("Enter the radius: --> ");
        Scanner stdin = new Scanner (System.in);
        radius = stdin.nextDouble(); // new inputed value is radius

        //Computing Area
        area = radius * radius * 3.14159;

        //Displaying Results
        System.out.println("The area for the circle" + " of radius " + radius + " is " + area);

        stdin.close();
    }
}
