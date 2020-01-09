public class Grid {
    Cell[] cells;
    int gridSize;
    Grid(int gridSize){
        this.gridSize=gridSize;
        this.cells=new Cell[gridSize];
        createCells();
    }
    void createCells(){
        for(int iterator=0;iterator<gridSize;iterator++){
            cells[iterator]=new Cell(iterator,String.valueOf(iterator));
        }

    }
    public Cell[] getCells() {
        return cells;
    }

    boolean modifyCellsSymbol(int location, String symbol){
        if(location<0 || location>gridSize){
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
        return cells[location].isMarked();
    }

    public void display(){
        System.out.println(cells[0].getSymbol()+" "+cells[1].getSymbol()+" "+cells[2].getSymbol());
        System.out.println(cells[3].getSymbol()+" "+cells[4].getSymbol()+" "+cells[5].getSymbol());
        System.out.println(cells[6].getSymbol()+" "+cells[7].getSymbol()+" "+cells[8].getSymbol());

    }
    boolean isAllCellsMarked(){
        for(int i=0;i<gridSize;i++){
            if(!isAlreadyMarked(i)){
                return false;
            }
        }
        return true;
    }
}
