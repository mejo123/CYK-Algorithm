import java.util.ArrayList;

public class ChomskyVerification {

    public boolean isValid(ArrayList<Grammar> grammarList) {
        boolean vaild = false;

        for (Grammar grammar : grammarList) {
            if (!(grammar.getLefthand().length() == 1 && Character.isUpperCase(grammar.getLefthand().charAt(0)))) {
                return false;
            }

            for (String terminalsAndStates : grammar.getRighthand()) {
                if (terminalsAndStates.length() == 1 && Character.isLowerCase(terminalsAndStates.charAt(0))) {
                    vaild = true;
                } else if (terminalsAndStates.length() == 2 && Character.isUpperCase(terminalsAndStates.charAt(0)) && Character.isUpperCase(terminalsAndStates.charAt(1))) {
                    vaild = true;
                } else
                    return false;
            }
        }

        return vaild;
    }
}
