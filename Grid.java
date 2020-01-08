public class Grid {

    Cell[] cells;
    Grid(){
        this.cells=new Cell[9];
        createCells(9);
    }
    void createCells(int size){
        for(int iterator=0;iterator<size;iterator++){
            cells[iterator]=new Cell(iterator,String.valueOf(iterator));
        }

    }
    public Cell[] getCells() {
        return cells;
    }

    boolean modifyCellsSymbol(int location, String symbol){
        if(location<0 || location>8){
            System.out.println("invalid location");
            return false;
        }
        if(!isAlreadyMarked(location)) {
            this.cells[location].setSymbol(symbol);
            return true;
        }
        System.out.println("location already got marked");
            return false;
    }

    boolean isAlreadyMarked(int location){
        return (cells[location].equals("X")||cells[location].equals("Y"));
    }

    public void display(){
        System.out.println(cells[0].getSymbol()+" "+cells[1].getSymbol()+" "+cells[2].getSymbol());
        System.out.println(cells[3].getSymbol()+" "+cells[4].getSymbol()+" "+cells[5].getSymbol());
        System.out.println(cells[6].getSymbol()+" "+cells[7].getSymbol()+" "+cells[8].getSymbol());

    }
}
