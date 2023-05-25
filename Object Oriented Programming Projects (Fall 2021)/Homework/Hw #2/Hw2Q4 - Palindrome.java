import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print("Enter the input string: ");
        input = sc.nextLine();
        String inputToLower = input.toLowerCase();
        int start = 0;
        int end = inputToLower.length() - 1;


        //Checking for not a palindrome instead of checking if it  is!
        while(start < end)
        {
            if(inputToLower.charAt(start) != inputToLower.charAt(end))
            {
                if(!(inputToLower.charAt(start) != ' ' && inputToLower.charAt(end) == ' ') && !(inputToLower.charAt(start) == ' ' && inputToLower.charAt(end) != ' '))
                {
                    System.out.println("Input string " + input + " is NOT a palindrome");
                    return;
                }
            }
            start++;
            end--;
        }
        System.out.println("Input string " + input + " is a palindrome");
    }
}
//break breaks only the while loop
// return (when its just return; meaning return nothing) will break everything