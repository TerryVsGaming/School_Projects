import java.util.Scanner;
public class Lab8 {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);


        //Part 1
        System.out.println("Part 1" + "\n");
        int counter = 65;
        int randomCharCode;
        char randomCharLetter;

        while (counter >= 65 && counter <= 90){
            randomCharCode = (int) (65 + Math.random() * 26);
            randomCharLetter = (char) randomCharCode;

            System.out.print(randomCharLetter + " ");
            counter++;
        }

        System.out.println("\n");
        System.out.println("part 2" + "\n");

        int counter2 = 0;
        int randomLetterCode;
        char randomCapitalLetters;
        char randomNumbers;

        while(counter2 >= 0 && counter2 <= 2){
            randomLetterCode = (int) (65 + Math.random() * 26);
            randomCapitalLetters = (char) randomLetterCode;
            System.out.print(randomCapitalLetters);
            counter2++;
        }

        while(counter2 >= 3 && counter2 <=6){
            randomLetterCode = (int) (48 + Math.random() * 10);
            randomNumbers = (char) randomLetterCode;
            System.out.print(randomNumbers);
            counter2++;
        }





    }
}
