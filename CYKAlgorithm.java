import java.util.ArrayList;


public class CYKAlgorithm {
    public ArrayList<Character> getNonTerminals(ArrayList<Grammar> grammarList) {
        ArrayList<Character> nonTerminal = new ArrayList<>();

        for (Grammar grammar : grammarList) {
            nonTerminal.add(grammar.getLefthand().charAt(0));
        }

        return nonTerminal;
    }
    public char getNonTerminal(Grammar grammarList) {
          return  nonTerminal.add(grammar.getLefthand().charAt(0));
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

        for(Grammar z : grammarList)
        {
          derivations = findTerminalProductions(z);
        }

        return derivations;
    }

    public ArrayList<Derivation> findTerminalProductions(Grammar grammar, ArrayList<Derivation> derivations, String target)
    {
      int size = grammar.rightHand().size();
      char nonterminal = grammar.getNonTerminal();
      for ( String x : grammar.rightHand() )
      {
        if (Character.isLowerCase(x.atChar(0)))
        {
          for ( Derivation y : derivations)
          {
            for( int j = 0; j < target.length(); ++ j)
            {
              if(nonterminal == y.nonTerminal && y.row == 1 && target.at(j) == x.atChar(0))
              {
                y.setValid = true;
              }
            }
          }
        }
      }
      return derivations;
    }

}
