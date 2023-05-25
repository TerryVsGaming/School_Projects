import java.util.Arrays;
import java.util.Scanner;

public class HW3Q4 {

    public static boolean isAnagram(String string1, String string2) {
        int[] counter1 = new int[123];
        int[] counter2 = new int[123];

        String string1lower = string1.toLowerCase();
        String string2lower = string2.toLowerCase();


        for (int index = 0; index < string1lower.length(); index++) {
            if (string1lower.charAt(index) == ' ') {
                continue;
            } else {
                counter1[string1lower.charAt(index)]++;
            }

        }

        for (int index2 = 0; index2 < string2lower.length(); index2++) {
            if (string2lower.charAt(index2) == ' ') {
                continue;
            } else {
                counter2[string2lower.charAt(index2)]++;
            }

        }

        if (Arrays.equals(counter1, counter2)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the First String: ");
        String firstString = sc.nextLine();


        System.out.print("Enter the Second String: ");
        String secondString = sc.nextLine();


        System.out.print(firstString + " and " + secondString + " are anagrams: "
                + isAnagram(firstString, secondString));
    }

}
