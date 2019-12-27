public class GameMonitor {
    Grid grid;
    Person x;
    Person y;
    String turn;

    GameMonitor(){
        this.grid=new Grid();
        this.x=new Person("X");
        this.y=new Person("Y");
        this.turn="X";
    }
    void changeTurn(){
        if(turn.equals("X")){
            turn="Y";
        }else{
            turn="X";
        }
    }
    boolean check(String s){
        if(s.equals("XXX")){
            System.out.println("Player X is winner");
            return true;
        }
        else if(s.equals("YYY")){
            System.out.println("Player Y is winner");
            return true;
        }
        return false;
    }
    boolean checkForWinner(){
        //Total 8 possibilities
        boolean flag;
        flag=check(grid.tiles[0]+grid.tiles[1]+grid.tiles[2])||
                check(grid.tiles[3]+grid.tiles[4]+grid.tiles[5])||
                check(grid.tiles[6]+grid.tiles[7]+grid.tiles[8])||
                check(grid.tiles[0]+grid.tiles[3]+grid.tiles[6])||
                check(grid.tiles[1]+grid.tiles[4]+grid.tiles[7])||
                check(grid.tiles[2]+grid.tiles[5]+grid.tiles[8])||
                check(grid.tiles[0]+grid.tiles[4]+grid.tiles[8])||
                check(grid.tiles[2]+grid.tiles[4]+grid.tiles[6])

        ;
        return flag;
    }
    public static void main(String[] args){
        GameMonitor game=new GameMonitor();
        System.out.println("Game started");
        boolean finished=false;
        int location;
        int i=0;
        while(i<9){
            game.grid.Display();
            if(game.turn.equals("X")){
                System.out.println("X's Turn");
                if(game.grid.modifyGrid(game.x.mark(),"X")){
                    i++;
                    game.changeTurn();
                    finished=game.checkForWinner();
                    if(finished){
                        break;
                    }
                }
            }
            else{
                System.out.println("Y's Turn");
                if(game.grid.modifyGrid(game.y.mark(),"Y")){
                    i++;
                    game.changeTurn();
                    finished=game.checkForWinner();
                    if(finished){
                        break;
                    }
                }
            }
        }
        if(!finished){
            System.out.println("Draw");
        }
    }
}
