import java.util.ArrayList;

public class CYKAlgorithm {
    public ArrayList<Character> getNonTerminals(ArrayList<Grammar> grammarList) {
        ArrayList<Character> nonTerminal = new ArrayList<>();

        for (Grammar grammar : grammarList) {
            nonTerminal.add(grammar.getLefthand().charAt(0));
        }

        return nonTerminal;
    }

    public ArrayList<Derivation> runCYK(ArrayList<Grammar> grammarList, String stringToLookFor) {
        ArrayList<Derivation> derivations = new ArrayList<>();
        ArrayList<Character> nonTerminals = getNonTerminals(grammarList);
        int columnSize = stringToLookFor.length();

        for (int row = 1; row <= stringToLookFor.length(); row++) {
            for (int column = 1; column <= columnSize; column++) {
                for (char nonTerminal : nonTerminals) {
                    derivations.add(new Derivation(row, column, nonTerminal, false));
                }
            }
            columnSize--;
        }

        return derivations;
    }
}
