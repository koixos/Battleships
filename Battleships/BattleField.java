import java.util.Scanner;

public class BattleField {
	private final Scanner inp = new Scanner(System.in);
	private Admiral admiral;
	private Kreuzers kreuzers;
	private Destroyer destroyer;
	private Submarine submarine;
	private final int[][] battleField = new int[10][10];

	public BattleField() {
		this.admiral = new Admiral();
		this.kreuzers = new Kreuzers();
		this.destroyer = new Destroyer();
		this.submarine = new Submarine();
	}

	public void fillTheField() {
		System.out.print("jksdhnuskveı");
	}

	//public int getTrap
}
