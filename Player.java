import java.util.Scanner;
public class Player {
    String name;
    String symbol;

    public Player(String name,String symbol) {
        this.name = name;
        this.symbol=symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int markOnTheGrid(){
        Scanner scan=new Scanner(System.in);
        System.out.println("enter a position to mark:");
        int location=scan.nextInt();

        return location;
    }
}
