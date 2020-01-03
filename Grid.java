public class Grid {

    String[] cells;
    Grid(){
        this.cells=new String[]{"1","2","3","4","5","6","7","8","9"};
    }

    public String[] getCells() {
        return cells;
    }

    Grid modifyGrid(int location, String symbol){
        if(!checkWhetherAlreadyMarked(location)) {
            this.cells[location - 1] = symbol;
            return this;
        }
            return this;
    }

    boolean checkWhetherAlreadyMarked(int location){
        if(cells[location-1].equals("X")||cells[location-1].equals("Y")){
            return true;
        }
            return false;
    }

    public void display(){
        System.out.println(cells[0]+" "+cells[1]+" "+cells[2]);
        System.out.println(cells[3]+" "+cells[4]+" "+cells[5]);
        System.out.println(cells[6]+" "+cells[7]+" "+cells[8]);

    }
}
