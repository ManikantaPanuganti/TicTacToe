public class Grid {
    String[] tiles;
    Grid(){
        this.tiles=new String[]{"1","2","3","4","5","6","7","8","9"};
    }
    boolean modifyGrid(int location,String update){
        if((location-1)<0||(location-1)>8) {
            System.out.println("Enter a valid location");
            return false;
        }
        else {
            if(tiles[location-1].equals("X")||tiles[location-1].equals("Y")){
                System.out.println("Already someone marked IT");
                return false;
            }
            else {
                this.tiles[location - 1] = update;
                return true;
            }
        }
    }
    public void Display(){
        System.out.println(tiles[0]+" "+tiles[1]+" "+tiles[2]);
        System.out.println(tiles[3]+" "+tiles[4]+" "+tiles[5]);
        System.out.println(tiles[6]+" "+tiles[7]+" "+tiles[8]);

    }
}
