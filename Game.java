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

    void changeTurn(){
        if(turn==player1){
            turn=player2;
        }else{
            turn=player1;
        }
    }

    boolean checkForWinner(){
    //can change the logic of checkWinner
        boolean flag;
        Cell[] cells=grid.getCells();
        flag=matchingString(cells[0].getSymbol()+cells[1].getSymbol()+cells[2].getSymbol())||
                matchingString(cells[3].getSymbol()+cells[4].getSymbol()+cells[5].getSymbol())||
                matchingString(cells[6].getSymbol()+cells[7].getSymbol()+cells[8].getSymbol())||
                matchingString(cells[0].getSymbol()+cells[3].getSymbol()+cells[6].getSymbol())||
                matchingString(cells[1].getSymbol()+cells[4].getSymbol()+cells[7].getSymbol())||
                matchingString(cells[2].getSymbol()+cells[5].getSymbol()+cells[8].getSymbol())||
                matchingString  (cells[0].getSymbol()+cells[4].getSymbol()+cells[8].getSymbol())||
                matchingString(cells[2].getSymbol()+cells[4].getSymbol()+cells[6].getSymbol());
        return flag;
    }
    boolean matchingString(String checkingString){
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

    void gameOver(){
        if(checkForWinner()){
            System.out.println(turn.getName()+" is the winner");
        }
        else{
            System.out.println("Game is draw!");
        }
    }

    void startGame(){
        int totalTurns=9;
            while(totalTurns>0){
                grid.display();
                System.out.println(turn.getName()+"'s turn");
                if(grid.modifyCellsSymbol(turn.markOnTheGrid(),turn.getSymbol())) {
                    if(checkForWinner())
                        break;
                    changeTurn();
                    totalTurns--;
                }
            }
            grid.display();
            gameOver();
    }
}
