public class extraCredit {
    /*
    Problem (given ~10/13): Create a method that does the Substring method
    */



    public static String oneSubstring(String string1, int startingIndex) {
        String printingString = "";
        for (int index = startingIndex; index < string1.length(); index++) {


            printingString += string1.charAt(index);

        }
        return printingString;
    }

    public static String twoSubstring(String string2, int startingIndex, int endingIndex) {
        String printingString2 = "";
        for (int index = startingIndex; index < endingIndex; index++) {


            printingString2 += string2.charAt(index);

        }
        return printingString2;
    }

        public static void main (String[]args){
            System.out.println(oneSubstring("Apple", 6));
            System.out.println(twoSubstring("Banana", 2, 5));
        }
    }
