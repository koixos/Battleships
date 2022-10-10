import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Battleships {
    private final Scanner inp = new Scanner(System.in);
    private Token token;
    private TokenNFT nftToken;
    private final Player[] players = new Player[2];
    private final BattleField[] battleFields = new BattleField[2];

    public void start() {
        System.out.print("\n====================== BATTLESHIPS ======================\n");
        for (int i = 0; i < players.length; i++) {
            System.out.print("\nPlayer " + (i+1) + "\n\t-> Enter your name: ");
            String name = this.inp.nextLine();
            players[i] = new Player(name);
            battleFields[i] = new BattleField();
        }
        Player
                p1 = this.players[0],
                p2 = this.players[1];

        BattleField
                f1 = this.battleFields[0],
                f2 = this.battleFields[1];

        System.out.print("Welcome my dear friends! Let's bet!\n\n");
        for (Player player : players) {
            System.out.print("\t-> " + player.getName() + "'s bet: ");
            double amount = this.inp.nextDouble();
            player.setBalance(amount);
        }

        System.out.print("\nAll done! We have a little gift for you to spend...\n");
        for (Player player : players) {
            double totalValueOfShips = BattleField.totalValueOfShips(player);
            System.out.print("\n\t-> " + player.getName() + "'s balance: " + player.getBalance() + " + " + totalValueOfShips);
            player.setBalance(player.getBalance() + totalValueOfShips);
        }

        System.out.print("\n\nAlright, everything is ready to go!\n\nLet's decide who to attack first... ");
        if (firstMove() == 1) {
            p1 = this.players[1];
            p2 = this.players[0];

            f1 = this.battleFields[1];
            f2 = this.battleFields[0];
        }
        System.out.print("How lucky you are " + p1.getName() + "! Let the game begin!!\n");
        this.inp.nextLine();

        while (true) {
            f1.printBothField(f1,f2,p1,p2);
            for (Player player : players)
                System.out.print("-> Balance of " + player.getName() + ": " + player.getBalance() + "\n");
            if (this.play(p1,p2,f2))
                break;
            f2.printBothField(f1,f2,p1,p2);
            if (this.play(p2,p1,f1))
                break;
        }
        System.out.print("\n\t-> " + p1.getName() + "'s total balance: " + p1.getBalance() + "\n\t-> " + p2.getName() + "'s total balance: " + p2.getBalance() + "\n");
    }

    public boolean play(Player attacker, Player defender, BattleField battleField) {
        int[] arr;
        String pos;

        while (true) {
            System.out.print("\nMake a move " + attacker.getName() + ": ");
            arr = this.validatePosition(battleField);
            if (arr[0] != -1 && arr[1] != -1) {
                pos = battleField.getPosition(arr[0], arr[1]);
                break;
            }
        }
        if (pos.equals("W ")) {
            System.out.print("Congrats! You found your enemy's treasure!\n");
            attacker.setBalance(attacker.getBalance()+ defender.getBalance());
            defender.setBalance(0);
            battleField.conquerPosition(arr[0],arr[1]);
        } else if (pos.equals("X ")) {
            System.out.print("\nOh no! You fell into a trap! You lost all your treasure...\n");
            defender.setBalance(defender.getBalance()+ attacker.getBalance());
            attacker.setBalance(0);
            attacker.setRemainedLife(attacker.getRemainedLife() - 1);
            if (attacker.getRemainedLife() <= 0) {
                System.out.print("Game over for you " + attacker.getName() + "...\nWell done " + defender.getName() + "! You won!!\n");
                return true;
            }
            System.out.print("You have only " + attacker.getRemainedLife() + " chance remained! Please think twice where to attack...\n");
        } else if (battleField.getShip(arr[0],arr[1]) != null) {
            Ship tempShip = battleField.getShip(arr[0],arr[1]);
            System.out.print("Lucky! You capsized your enemy's " + tempShip.getSHipName() + "! (+" + tempShip.getValue() + ")\n\n");
            attacker.setBalance(attacker.getBalance()+tempShip.getValue());
            defender.setBalance(defender.getBalance()-tempShip.getValue());

            battleField.getShip(arr[0],arr[1]).setRemained(tempShip.getRemained()-1);
            battleField.attackShip(arr[0], arr[1]);
            defender.setTotalShips(defender.getTotalShips()-1);
            if (this.checkShips(defender)) {
                System.out.print("We have bad news captain... All the ships are conquered! We have sustained a terrible defeat...\nCongrats " + attacker.getName() + "! You defeated all the enemy and won!\n");
                return true;
            }
        }
        battleField.conquerPosition(arr[0], arr[1]);
        return false;
    }

    public int[] validatePosition(BattleField battleField) {
        int[] arr = {-1, -1};
        String inp = this.inp.nextLine();
        byte[] bytes = inp.getBytes(StandardCharsets.UTF_8);
        if (bytes.length != 2)
            System.out.print("Enter a valid position.\n");
        else {
            int column = bytes[0] - 64;
            int row = bytes[1] - 47;

            if (column >= 33 && column <= 42)
                column -= 32;

            if (row < 1 || row > 10 || column < 1 || column > 10)
                System.out.print("Enter a valid position\n");
            else if(battleField.getPosition(row, column).equals("#"))
                System.out.print("This position already conquered. Select another position.\n");
            else {
                arr[0] = row;
                arr[1] = column;
            }
        }
        return arr;
    }

     public boolean checkShips(Player defender) {
        return defender.getTotalShips() <= 0;
     }
    public int firstMove() {
         return (int)(Math.random() * 2);
    }

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
}
