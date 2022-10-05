import java.util.Scanner;

public class Battleships {
    private final Scanner inp = new Scanner(System.in);
    private Token token;
    private TokenNFT nftToken;
    private final Player[] players = new Player[2];
    private final BattleField[] battleFields = new BattleField[2];

    public void start() {
        System.out.print("\n====================== BATTLESHIPS ======================\n");
        System.out.print("\nPlayer 1\n\t-> Please enter your name: ");
        players[0] = new Player(inp.nextLine());
        System.out.print("\nPlayer 2\n\t-> Please enter your name: ");
        players[1] = new Player(inp.nextLine());

    } /* END OF start */

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public TokenNFT getNftToken() {
        return nftToken;
    }

    public void setNftToken(TokenNFT nftToken) {
        this.nftToken = nftToken;
    }

    public Player[] getPlayers() {
        return players;
    }

    public BattleField[] getBattleFields() {
        return battleFields;
    }
}
