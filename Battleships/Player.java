public class Player {
    private final String name;
    private double balance;
    private int totalShips;
    private int remainedLife;

    public Player(String name) {
        this.name = name;
        this.balance = 0;
        this.totalShips = 0;
        this.remainedLife = BattleField.getTrap();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTotalShips() {
        return totalShips;
    }

    public void setTotalShips(int totalShips) {
        this.totalShips = totalShips;
    }

    public int getRemainedLife() {
        return remainedLife;
    }

    public void setRemainedLife(int remainedLife) {
        this.remainedLife = remainedLife;
    }
}
