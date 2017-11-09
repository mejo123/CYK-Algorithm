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
        int rowSize = stringToLookFor.length();

        for (int column = 1; column < stringToLookFor.length(); column++) {
            for (int row = 1; row < rowSize; row++) {
                for (char nonTernimal : nonTerminals) {
                    derivations.add(new Derivation(column, row, nonTernimal, false));
                }
            }
            rowSize--;
        }

        return derivations;
    }
}
