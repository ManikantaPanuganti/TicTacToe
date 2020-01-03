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

    boolean checkForWinnerHelper(String checkingString){
        String winningLiteral1="XXX";
        String winningLiteral2="YYY";

        if(checkingString.equals(winningLiteral1)){
            return true;
        }
        else if(checkingString.equals(winningLiteral2)){
            return true;
        }
        return false;
    }


    boolean checkForWinner(){

        boolean flag;
        String[] cells=grid.getCells();
        flag=checkForWinnerHelper(cells[0]+cells[1]+cells[2])||
                checkForWinnerHelper(cells[3]+cells[4]+cells[5])||
                checkForWinnerHelper(cells[6]+cells[7]+cells[8])||
                checkForWinnerHelper(cells[0]+cells[3]+cells[6])||
                checkForWinnerHelper(cells[1]+cells[4]+cells[7])||
                checkForWinnerHelper(cells[2]+cells[5]+cells[8])||
                checkForWinnerHelper(cells[0]+cells[4]+cells[8])||
                checkForWinnerHelper(cells[2]+cells[4]+cells[6]);
        return flag;
    }


    void startGame(){
        Player currentPlayer=player1;
        int totalTurns=9;
            while(totalTurns>=0){
                grid.display();
                System.out.println(currentPlayer.getName());
                grid.modifyGrid(currentPlayer.mark(),currentPlayer.getSymbol());
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
