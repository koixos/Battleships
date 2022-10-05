public class Player {
    private final String name;
    private double balance;

    public Player(String name) {
        this.name = name;
        this.balance = 0;
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
}
