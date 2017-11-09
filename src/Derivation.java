public class Derivation {
    private int column;
    private int row;
    private char nonTerminal;
    private boolean isVaild;

    public Derivation(int column, int row, char nonTerminal, boolean isVaild) {
        this.column = column;
        this.row = row;
        this.nonTerminal = nonTerminal;
        this.isVaild = isVaild;
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

    public boolean isVaild() {
        return isVaild;
    }

    public void setVaild(boolean vaild) {
        isVaild = vaild;
    }
}
