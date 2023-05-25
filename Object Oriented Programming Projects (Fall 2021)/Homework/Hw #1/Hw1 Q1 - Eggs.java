import java.util.Scanner;
public class Eggs {
    public static void main (String[] args){
     Scanner sc = new Scanner (System.in);

     System.out.print("Please insert the number of eggs you would like to order: ");
     int totalEggs = sc.nextInt();

     int dozenEggs = totalEggs/12;
     int individualEggs = totalEggs%12;

     double priceOfDozens = dozenEggs * 3.25;
     double priceOfIndividual = individualEggs * 0.45;
     double totalPrice = priceOfDozens + priceOfIndividual;

     System.out.println();

     System.out.println("You ordered " + totalEggs + " eggs. That's " + dozenEggs + " dozen eggs at $3.25 per dozen and " + individualEggs +
             " loose eggs at 45 cents for a total of " + "$" + totalPrice);



    }
}
