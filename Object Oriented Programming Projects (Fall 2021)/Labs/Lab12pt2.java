public class Lab12pt2 {


    public static double sum (int i){
        double total = 0;
        for(double temp = 1; temp <= i; temp++){
            total += (temp/(temp+1));
        }
        return total;
    }

    public static void main (String[] args){
        for(int i = 1; i <= 20; i++){
            System.out.println((i) + "     " + sum(i));
        }

    }

}
