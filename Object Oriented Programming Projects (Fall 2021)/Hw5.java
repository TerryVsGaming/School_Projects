public class Hw5 {

    public static void main(String[] args) {


        if(canVote(19)){
            System.out.println("You Can Vote");
            if(canDrink(19)){
                System.out.println("You Can Drink");
            }
            else{
                System.out.println("You Cannot Drink");
            }
        }

        else{
            System.out.println("You Can Neither Vote Nor Drink");
        }
    }


    public static boolean canVote(int voteAge) {

        if (voteAge >= 18) {
            return true;
        } else {
            return false;
        }
    }

public static boolean canDrink(int drinkAge){
    if (drinkAge >= 21) {
        return true;
    } else {
        return false;
    }
}





}







