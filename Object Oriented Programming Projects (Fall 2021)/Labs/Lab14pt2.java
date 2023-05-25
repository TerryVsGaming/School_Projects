public class Lab14pt2 {

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

    public static void main(String[] args) {
        int count = 1;
        int a = 0;
        int b = a+2;

        while (a <= 1000) {

            if (isPrime(a) && isPrime(b)) {
                System.out.println(count + ": " + a + ", " + b);

                count++;
            }

            a++;
            b++;

        }
    }


}
