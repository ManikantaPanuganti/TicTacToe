public class Game {
    Grid grid;
    Player player1;
    Player player2;
    Player turn;

    Game(){
        grid=new Grid();
        player1=new Player("Motu","X");
        player2=new Player("Patlu","Y");
        turn=player1;
    }

    void changeTurn(Player currentPlayer){
        if(turn==player1){
            turn=player2;
        }else{
            turn=player1;
        }
    }

    boolean checkForWinnerHelper(String s){
        String winningLiteral1="XXX";
        String winningLiteral2="YYY";

        if(s.equals(winningLiteral1)){
            return true;
        }
        else if(s.equals(winningLiteral2)){
            return true;
        }
        return false;
    }


    boolean checkForWinner(){
        //Total 8 possibilities
        boolean flag;
        flag=checkForWinnerHelper(grid.cells[0]+grid.cells[1]+grid.cells[2])||
                checkForWinnerHelper(grid.cells[3]+grid.cells[4]+grid.cells[5])||
                checkForWinnerHelper(grid.cells[6]+grid.cells[7]+grid.cells[8])||
                checkForWinnerHelper(grid.cells[0]+grid.cells[3]+grid.cells[6])||
                checkForWinnerHelper(grid.cells[1]+grid.cells[4]+grid.cells[7])||
                checkForWinnerHelper(grid.cells[2]+grid.cells[5]+grid.cells[8])||
                checkForWinnerHelper(grid.cells[0]+grid.cells[4]+grid.cells[8])||
                checkForWinnerHelper(grid.cells[2]+grid.cells[4]+grid.cells[6]);
        return flag;
    }


    void startGame(){
        Player currentPlayer=player1;
        int totalTurns=9;
            while(totalTurns>=0){
                grid.display();
                System.out.println(currentPlayer.name);
                grid.modifyGrid(currentPlayer.mark(),currentPlayer.symbol);
                changeTurn(currentPlayer);
                if(checkForWinner())
                    break;
                totalTurns--;
                currentPlayer=turn;
            }
            if(totalTurns==0){
                System.out.println("Draw");
            }
            else{
                System.out.println("Winner is "+currentPlayer.name);
            }



    }

}
