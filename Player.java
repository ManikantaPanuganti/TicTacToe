import java.util.*;
public class Player {
    String name;
    String symbol;

    public Player(String name,String symbol) {
        this.name = name;
        this.symbol=symbol;
    }

    public int mark(){
        Scanner scan=new Scanner(System.in);
        int location=scan.nextInt();
        return location;
    }
}
