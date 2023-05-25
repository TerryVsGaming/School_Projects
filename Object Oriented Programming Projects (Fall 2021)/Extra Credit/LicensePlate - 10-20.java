/**
 * Random car plate using arrays (string array + int array) - 10/20/2012
 */


public class LicensePlate {
    public static void main(String[] args) {
        int[] intArray = new int[3];
        char[] charArray = new char[3];

        for (int index = 0; index < charArray.length; index++) {
            charArray[index] = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            intArray[index] = (int) (Math.random() * 9);
        }

        for (int index2 = 0; index2 < intArray.length; index2++) {
            System.out.print(intArray[index2]);
        }

        for (int index3 = 0; index3 < charArray.length; index3++) {
            System.out.print(charArray[index3]);
        }


    }
}

