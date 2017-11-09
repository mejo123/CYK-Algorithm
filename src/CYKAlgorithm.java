import java.util.ArrayList;

public class CYKAlgorithm {
    public ArrayList<ArrayList<String>> runCYK (ArrayList<Grammar> grammarList){
        ArrayList<ArrayList<String>> cyk = new ArrayList<>();
        ArrayList<String> containsGrammar = new ArrayList<>();
        cyk.add(grammarList.get(0).getRighthand());
        return cyk;
    }
}
