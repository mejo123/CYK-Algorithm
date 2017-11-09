import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String usersGrammar;
        ArrayList<Grammar> grammars = new ArrayList<Grammar>();
        Scanner scanner = new Scanner(System.in);
        ChomskyVerification chomskyVerification = new ChomskyVerification();
        CYKAlgorithm cyk = new CYKAlgorithm();

        System.out.println("Please Enter Grammar in this format X->X|X and when done type in done:");

        while (true) {
            usersGrammar = scanner.nextLine();
            if (usersGrammar.equals("done"))
                break;
            else if (!(usersGrammar.contains("->"))) {
                System.out.println("Please enter a grammar.");
                break;
            } else {
                ArrayList<String> rightHand = new ArrayList<>(Arrays.asList(usersGrammar.substring(usersGrammar.indexOf(">") + 1, usersGrammar.length()).split("\\|")));
                grammars.add(new Grammar(usersGrammar.substring(0, usersGrammar.indexOf("-")), rightHand));
            }
        }

        System.out.println(grammars.get(0).getLefthand() + grammars.get(0).getRighthand());

        if (!(chomskyVerification.isValid(grammars))) {
            System.out.println("Please enter a Chomsky normalize grammar");
        } else {
            ArrayList<ArrayList<String>> finalResult = cyk.runCYK(grammars);
            for (int i = finalResult.size(); i > 0; i--) {
                for (int j = 0; j < finalResult.get(i).size(); j++) {
                    if (finalResult.get(i).get(j).equals("-1")) {
                        System.out.print("{} ");
                    } else
                        System.out.print(finalResult.get(i).get(j) + " ");
                }
                System.out.print("\n");
            }

        }
    }

}

