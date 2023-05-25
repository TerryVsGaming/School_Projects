import java.util.Random;

public class Hw3 {



    public static void main (String[] args){
        int[] firstNumbers = new int[5];
        Random rand = new Random();

        for (int i = 0; i < firstNumbers.length; i++ ){
            firstNumbers[i] = rand.nextInt(150);

        }
        for(int firstNumber : firstNumbers){
            System.out.println ( firstNumber);
        }
    }


ArrayList <Integer> numbers = new ArrayList<Integer>();
    Random rand = new Random ();
    for (int i = 0; i < 5; i++){
        numbers.add(rand.nextInt(100) + 1);
    }


    for (int number : numbers){
        System.out.println(number);
    }















}
