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

        for (int i = 2; i <= stringToLookFor.length(); i++)
            for (int j = 1; j <= stringToLookFor.length() - i + 1; j++)
                for (int k = 1; k <= i - 1; k++) {
                    derivations = getDoubleNonTerminals(grammarList, derivations, i, j, k);
                }

        return derivations;
    }

    public ArrayList<Derivation> getDoubleNonTerminals(ArrayList<Grammar> grammarList, ArrayList<Derivation> derivations, int i, int j, int k) {
        for (Grammar grammar : grammarList)
            for (String nonTerminal : grammar.getRighthand())
                if (nonTerminal.length() == 2 && Character.isUpperCase(nonTerminal.charAt(0)) && Character.isUpperCase(nonTerminal.charAt(1)))
                    for (Derivation derivation : derivations)
                        for (Derivation derivation1 : derivations)
                            if (derivation.getRow() == k && derivation.getColumn() == j && derivation.getNonTerminal() == nonTerminal.charAt(0))
                                if (derivation1.getRow() == i - k && derivation1.getColumn() == j + k && derivation1.getNonTerminal() == nonTerminal.charAt(1))
                                    for (Derivation derivation2 : derivations)
                                        if (derivation2.getRow() == i && derivation2.getColumn() == j && derivation2.getNonTerminal() == grammar.getLefthand().charAt(0))
                                            derivation2.setValid(true);

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
