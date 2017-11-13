
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
        Boolean isNotContained = true;

        System.out.println("Welcome to our CYK Algorithm, Please enter a grammar in Chomsky Normal Form");
        System.out.println("The format should be X->X|X ,  whenever you are done with the productions, enter \"done\" ");

        while (true) {
            usersGrammar = scanner.nextLine();
            if (usersGrammar.equals("done") && chomskyVerification.isValid(grammars))
                break;
            else if (usersGrammar.equals("done") && !chomskyVerification.isValid(grammars)) {
                System.out.println();
                System.out.println("Please start over and enter a Chomsky normalize grammar");
                grammars.clear();
            } else if (!(usersGrammar.contains("->"))) {
                System.out.println();
                System.out.println("Please reenter a valid grammar with a correct syntax.");
            }else if (!(usersGrammar.matches("^[a-zA-Z->|]+$"))){
                System.out.println();
                System.out.println("Please reenter a valid grammar with a correct syntax.");
            } else {
                ArrayList<String> rightHand = new ArrayList<>(Arrays.asList(usersGrammar.substring(usersGrammar.indexOf(">") + 1, usersGrammar.length()).split("\\|")));
                grammars.add(new Grammar(usersGrammar.substring(0, usersGrammar.indexOf("-")), rightHand));
            }
        }

        System.out.println();
        System.out.println("Please enter the string you would like to check withing the grammar: ");
        stringToLookFor = scanner.nextLine();

        // Just for formatting
        System.out.println();

        ArrayList<Derivation> finalResult = cyk.runCYK(grammars, stringToLookFor);

        for (int i = stringToLookFor.length(); i > 0; i--) {
            for (int j = 1; j <= stringToLookFor.length() - i + 1; j++) {
                String output = "";

                for (Derivation d : finalResult) {
                    if (i == d.getRow() && j == d.getColumn() && d.isValid()) {
                        output += d.getNonTerminal();
                    }
                }
                if (output.isEmpty()) {
                    output = "-";
                }
                System.out.format("%-10s", output);
            }
            System.out.println();
        }

        System.out.println();

        for (Derivation derivation : finalResult) {
            if (derivation.getRow() == stringToLookFor.length() && derivation.getColumn() == 1 && derivation.isValid()) {
                System.out.println("String is contained in grammar.");
                isNotContained = false;
                break;
            }
        }

        if (isNotContained) {
            System.out.println("String is not contained in grammar.");
        }
    }
}
