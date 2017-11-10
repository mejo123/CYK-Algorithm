public class Derivation {
    private int row;
    private int column;
    private char nonTerminal;
    private boolean isValid;

    public Derivation(int row, int column, char nonTerminal, boolean isValid) {
        this.row = row;
        this.column = column;
        this.nonTerminal = nonTerminal;
        this.isValid = isValid;
    }

    public int getColumn() {

        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getNonTerminal() {
        return nonTerminal;
    }

    public void setNonTerminal(char nonTerminal) {
        this.nonTerminal = nonTerminal;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean vaild) {
        isValid = vaild;
    }
}
