public class Hw3 {

    public static void main (String[]args){

        for (int i = 1; i <= 6; i++) {
            for (int j = 6; j >= i; j--) {
                System.out.print("*");

            }

            System.out.println();

        }

        for (int k = 1; k <= 6; k++) { // number of line
            for (int l = 1; l <= k; l++) { // number of stars
                System.out.print("*");

            }

            System.out.println();

        }











    }

}
