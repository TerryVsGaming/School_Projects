public class Lab13 {



    public static void displayPattern(int n) {


for (int a = 1; a <= n; a++){

    for (int b = 1; b <= n-a; b++){
        System.out.print(" ");
    }
    for (int i = a; i > 0; i--) {
        System.out.print(i);


    }

    System.out.println();
}
    }


    public static void main (String[] args){
displayPattern(9);
    }






}
