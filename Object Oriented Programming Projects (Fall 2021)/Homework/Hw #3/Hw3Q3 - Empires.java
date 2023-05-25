public class Hw3Q3 {

    public static boolean isPrime(int number) {
        int counter = 0;
        int numbercopy = number;

        for (int i = 1; i <= number; i++) {

            if (numbercopy % i == 0) {
                counter++;
            }
        }

        if (counter != 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPalindrome(int number) {
// use int inside (so int number instead of String number) and then first line will convert it to String

        String stringOfNumber = String.valueOf(number);
        String word = "";

        for (int index = stringOfNumber.length() - 1; index >= 0; index--) {
            word += stringOfNumber.charAt(index);
        }

        if (word.equals(stringOfNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrimeBackwards(int number) {
        String forward = String.valueOf(number);
        String backwards = "";
        for (int index = forward.length() - 1; index >= 0; index--) {
            backwards += forward.charAt(index);
        }
        int intValue = Integer.parseInt(backwards);

        return isPrime(intValue);
    }


    public static void main(String[] args) {
        int count = 1;
        int a = 2;

        while (true) {
            if (isPrimeBackwards(a) && isPrime(a) && !isPalindrome(a)) {

                if ((count % 10) == 1) {
                    System.out.println();
                }

                System.out.print(count + ": " + a + " ");
                count++;
            }
            if (count > 100) {
                break;
            }
            a++;
        }
    }
}
