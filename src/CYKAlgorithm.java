import java.util.ArrayList;


public class CYKAlgorithm {
    public ArrayList<Character> getNonTerminals(ArrayList<Grammar> grammarList) {
        ArrayList<Character> nonTerminal = new ArrayList<>();

        for (Grammar grammar : grammarList) {
            nonTerminal.add(grammar.getLefthand().charAt(0));
        }

        return nonTerminal;
    }

    public char getNonTerminal(Grammar grammar) {
        return grammar.getLefthand().charAt(0);
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

        for (Grammar z : grammarList) {
            derivations = findTerminalProductions(z, derivations, stringToLookFor);
        }

        return derivations;
    }

    public ArrayList<Derivation> findTerminalProductions(Grammar grammar, ArrayList<Derivation> derivations, String target) {
        char nonTerminal = getNonTerminal(grammar);
        for (String x : grammar.getRighthand()) {
            if (Character.isLowerCase(x.charAt(0))) {
                for (Derivation y : derivations) {
                    if (nonTerminal == y.getNonTerminal() && y.getRow() == 1 && target.charAt(y.getColumn() - 1) == x.charAt(0)) {
                        y.setValid(true);
                    }
                }
            }
        }
        return derivations;
    }

}
