public class Lab12 {


    public static int letterCounter(String word, char letter){
        int counter = 0
                ;
        for(int index = 0; index <= word.length()-1; index++){
            if (word.toLowerCase().charAt(index) == letter){
                counter++;

            }

        }
        return counter;
    }


    public static void main (String[] args){

        System.out.print(letterCounter("Welcome", 'e'));
    }





}
