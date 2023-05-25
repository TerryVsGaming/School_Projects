import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {

        //Part 2
        System.out.println("Part 1" + "\n");
        Scanner sc = new Scanner(System.in);

        double total = 0;
        int counter = 0;

        while (counter < 10) {
            int randNumber = (int) (Math.random() * 100);
            System.out.println(randNumber + "\n");
            total += randNumber;
            counter++;
        }

        System.out.println("Average: " + total / counter);


//Part 2
        System.out.println("Part 2" + "\n");

        System.out.print("Please Insert the First City: ");
        String cityOne = sc.nextLine();

        System.out.print("Please Insert the Second City: ");
        String cityTwo = sc.nextLine();

        System.out.print("Please Insert the Third City: ");
        String cityThree = sc.nextLine();


        int oneVsTwo = cityOne.compareTo(cityTwo);
        int oneVsThree = cityOne.compareTo(cityThree);
        int twoVsThree = cityTwo.compareTo(cityThree);

System.out.println(oneVsTwo);

//Second String compares with First!
            // if equal returns 0
            // 1 if city 1 is greater
            // -1 if city 2 is greater


        if (oneVsTwo < 0 && oneVsThree < 0){
            System.out.println(cityOne);
            if(twoVsThree < 0) {
                System.out.println(cityTwo);
                System.out.println(cityThree);
            }
            else if (twoVsThree > 0){
                System.out.println(cityThree);
                System.out.println(cityTwo);
            }
        }

        if (oneVsTwo > 0 && twoVsThree < 0){
            System.out.println(cityTwo);
            if(oneVsThree < 0){
                System.out.println(cityOne);
                System.out.println(cityThree);
            }

            else if (oneVsThree > 0){
                System.out.println(cityThree);
                System.out.println(cityOne);
            }

        }


        if (oneVsThree > 0 && twoVsThree > 0){
            System.out.println(cityThree);
            if(oneVsTwo < 0){
                System.out.println(cityOne);
                System.out.println(cityTwo);
            }
            else if (oneVsTwo > 0){
                System.out.println(cityTwo);
                System.out.println(cityOne);
            }
        }




    }
}