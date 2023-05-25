import java.util.Scanner;
    public class commonPrefix {
        public static void main (String [] args){
            Scanner sc = new Scanner (System.in);
            System.out.print("Please Enter your First String: ");
            String string1 = sc.nextLine();

            System.out.print("Please Enter your Second String: ");
            String string2 = sc.nextLine();

            int indexNumber = 0;
            int indexNumber2 = 0;
            String prefix = "";

            while (string1.charAt(indexNumber) == string2.charAt(indexNumber)){
                prefix += string1.charAt(indexNumber);

                if(string1.length() > string2.length() && string2.length() - 1 == indexNumber){
                break;
                        }

                if (string1.length() < string2.length() && string1.length() - 1 == indexNumber){
                    break;
                        }

                if (string1.length() == string2.length() && string1.length() - 1 == indexNumber){
                    break;
                        }
                        indexNumber++;
            }

                if (prefix.length() > 0){
                    System.out.print("The Common Prefix(s): " + prefix);
                    }

                else{
                    System.out.println("No Common Prefix(s)" + prefix);
                    }



                }
            }
