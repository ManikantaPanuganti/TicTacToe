public class Game {
    Grid grid;
    Player player1;
    Player player2;

    Game(){
        grid=new Grid(9);
        player1=new Player("Motu","X");
        player2=new Player("Patlu","Y");
    }
    Player changeTurn(Player turn){
        return turn==player1 ? player2:player1;
    }
    void gameOver(Player turn){
        if (checkForWinner()) {
            System.out.println(turn.getName() + " is the winner");
        } else {
            System.out.println("Game is draw!");
        }
    }
    void startGame(){
        Player turn=player1;
            while(!grid.isAllCellsMarked()){
                grid.display();
                System.out.println(turn.getName()+"'s turn");
                if(grid.modifyCellsSymbol(turn.markOnTheGrid(),turn.getSymbol())) {
                    if(checkForWinner())
                        break;
                    changeTurn(turn);
                }
            }
            grid.display();
            gameOver(turn);
    }
    boolean matchingString(String checkingString){
        String winningLiteral1=player1.getSymbol()+player1.getSymbol()+player1.getSymbol();
        String winningLiteral2=player2.getSymbol()+player2.getSymbol()+player2.getSymbol();
        return checkingString.equals(winningLiteral1)||checkingString.equals(winningLiteral2);

    }

    boolean checkForWinner(){
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

}
