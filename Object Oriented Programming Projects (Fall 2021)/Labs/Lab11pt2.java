import java.util.Scanner;
public class Lab11pt2 {
public static void main (String[] args){
Scanner sc = new Scanner (System.in);

System.out.println("Please insert the date in m/d/y format(if date/month <10 write 0 before the digit): ");
String date = sc.nextLine();


String month = date.substring(0,2);


String day = date.substring(3,5);
String year = date.substring(6,10);

if (month.equals("01") ){
    System.out.print("January ");
}

    if (month.equals("02") ){
        System.out.print("February ");
    }

    if (month.equals("03") ){
        System.out.print("March ");
    }

    if (month.equals("04") ){
        System.out.print("April ");
    }

    if (month.equals("05") ){
        System.out.print("May ");
    }

    if (month.equals("06") ){
        System.out.print("June ");
    }

    if (month.equals("07") ){
        System.out.print("July ");
    }

    if (month.equals("08") ){
        System.out.print("August ");
    }

    if (month.equals("09") ){
        System.out.print("September ");
    }

    if (month.equals("10") ){
        System.out.print("October ");
    }

    if (month.equals("11") ){
        System.out.print("November ");
    }

    if (month.equals("12") ){
        System.out.print("December ");
    }




System.out.println(day + " " + year);


    }
}
