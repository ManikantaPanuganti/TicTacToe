
public class Cell {
    int position;
    String symbol;
    boolean isMarked=false;
    public Cell(int position, String symbol) {
        this.position = position;
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public boolean isMarked(){
        return isMarked;
    }

}
