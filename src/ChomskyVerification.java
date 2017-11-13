import java.util.ArrayList;

public class ChomskyVerification {

    // Returns true if a grammar is in Chomsky form.
    public boolean isValid(ArrayList<Grammar> grammarList) {
        boolean isInfiniteState = true;

        // Need to loop through all the the productions
        for (Grammar grammar : grammarList) {
            if (!(grammar.getLefthand().length() == 1 && Character.isUpperCase(grammar.getLefthand().charAt(0)))) {
                return false;
            }

            // Need to loop through all the terminals/nonterminals in a productions
            for (String terminalsAndStates : grammar.getRighthand()) {
                // If out right hand side is only 1 letter and it is lower case, this is valid
                if (terminalsAndStates.length() == 1 && Character.isLowerCase(terminalsAndStates.charAt(0))) {
                }
                // If we have 2 uppercase next to each other this is also valid
                else if (terminalsAndStates.length() == 2 && Character.isUpperCase(terminalsAndStates.charAt(0)) && Character.isUpperCase(terminalsAndStates.charAt(1))) {
                } else {
                    return false;
                }

                // If we have do not have an infinite production then mark isInfiniteState false
                if (terminalsAndStates.length() == 2)
                    if (terminalsAndStates.charAt(0) != grammar.getLefthand().charAt(0) && terminalsAndStates.charAt(1) != grammar.getLefthand().charAt(0))
                        isInfiniteState = false;

            }
        }

        return !isInfiniteState;
    }
}
