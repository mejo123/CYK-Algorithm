
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String usersGrammar;
        String stringToLookFor;
        ArrayList<Grammar> grammars = new ArrayList<Grammar>();
        Scanner scanner = new Scanner(System.in);
        ChomskyVerification chomskyVerification = new ChomskyVerification();
        CYKAlgorithm cyk = new CYKAlgorithm();

        System.out.println("Welcome tou our CYK Algorithm, Please enter a grammar in Chomsky Normal Form");
        System.out.println("The format should be X->X|X ,  whenever you are done with the productions, enter \"done\" ");

        while (true) {
            usersGrammar = scanner.nextLine();
            if (usersGrammar.equals("done"))
                break;
            else if (!(usersGrammar.contains("->"))) {
                System.out.println("Please enter a valid grammar syntax.");
                break;
            } else {
                ArrayList<String> rightHand = new ArrayList<>(Arrays.asList(usersGrammar.substring(usersGrammar.indexOf(">") + 1, usersGrammar.length()).split("\\|")));
                grammars.add(new Grammar(usersGrammar.substring(0, usersGrammar.indexOf("-")), rightHand));
            }
        }
        System.out.println("Please enter the string you would like to check withing the grammar: ");
        stringToLookFor = scanner.nextLine();

        if (!(chomskyVerification.isValid(grammars))) {
            System.out.println("Please enter a Chomsky normalize grammar");
        } else {
            ArrayList<ArrayList<String>> finalResult = cyk.runCYK(grammars);
            for (int i = finalResult.size() - 1; i >= 0; i--) {
                for (int j = 0; j < finalResult.get(i).size(); j++) {
                    if (finalResult.get(i).get(j).equals("-1")) {
                        System.out.print("{} ");
                    } else{
                        System.out.print(finalResult.get(i).get(j) + " ");
                      }
                }
                System.out.print("\n");
            }

        }
    }

}
