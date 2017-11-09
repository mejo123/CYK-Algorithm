import java.util.ArrayList;

public class Grammar {
    private ArrayList<String> Righthand;
    private String Lefthand;

    public Grammar(String lefthand, ArrayList<String> righthand) {
        Lefthand = lefthand;
        Righthand = righthand;
    }

    public ArrayList<String> getRighthand() {
        return Righthand;
    }

    public void setRighthand(ArrayList<String> righthand) {
        Righthand = righthand;
    }

    public String getLefthand() {
        return Lefthand;
    }

    public void setLefthand(String lefthand) {
        Lefthand = lefthand;
    }
}
