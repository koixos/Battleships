import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BattleField {
	private final Scanner inp = new Scanner(System.in);
	private final String[][] field = new String[11][11];
	private final Ship[][] map = new Ship[11][11];
	private final Admiral admiral;
	private final Kreuzers kreuzers;
	private final Destroyer destroyer;
	private final Submarine submarine;
	private static final int trap = 2;

	public BattleField() {
		this.admiral = new Admiral();
		this.kreuzers = new Kreuzers();
		this.destroyer = new Destroyer();
		this.submarine = new Submarine();
		for (int row = 0; row < this.map.length; row++)
			for (int column = 0; column < this.map.length; column++)
				this.map[row][column] = null;
		this.createField();
		this.fillField();
	}

	public void createField() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (i == 0 && j == 0 || i != 0 && j != 0)
					this.field[i][j] = "  ";
				else {
					if (i == 0)
						this.field[i][j] = (char)(65+j-1) + " ";
					else
						this.field[i][j] = i-1 + " ";
				}
			}
		}
		this.printField();
	}

	public void fillField() {
		this.putShips(this.getAdmiral());
		this.putShips(this.getKreuzers());
		this.putShips(this.getDestroyer());
		this.putShips(this.getSubmarine());
		this.putTraps();
		this.hideTreasure();
	}

	public void putShips(Ship ship) {
		for (int i = 1; i <= ship.getRemained(); i++) {
			while (true) {
				int[] arr;
				System.out.print("Place your " + ship.getSHipName() + ": ");
				arr = this.validatePosition();
				if (arr[0] != -1 && arr[1] != -1) {
					this.field[arr[0]][arr[1]] = ship.getId() + " ";
					this.map[arr[0]][arr[1]] = ship;
					break;
				}
			}
		}
		this.printField();
	}

	public void putTraps() {
		for (int i = 0; i < trap; i++) {
			while (true) {
				int[] arr;
				System.out.print("Place a trap for your enemy: ");
				arr = this.validatePosition();
				if (arr[0] != -1 && arr[1] != -1) {
					this.field[arr[0]][arr[1]] = "X ";
					break;
				}
			}
		}
		this.printField();
	}

	public void hideTreasure() {
		while (true) {
			int[] arr;
			System.out.print("Hide your treasure: ");
			arr = this.validatePosition();
			if (arr[0] != -1 && arr[1] != -1) {
				this.field[arr[0]][arr[1]] = "W ";
				break;
			}
		}
		this.printField();
	}

	public void printField() {
		System.out.print("\n");
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++)
				System.out.print(this.field[i][j] + " ");
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public void printBothField(BattleField f1, BattleField f2, Player p1, Player p2) {
		BattleField[] fields = {f1, f2};
		System.out.print("\n\t\t" + p1.getName() + "'s field\t\t\t\t\t\t\t\t" + p2.getName() + "'s field\n----------------------------------------------------------------------------------------\n");
		for (int i = 0; i < 11; i++) {
			for (int k = 0; k < 2; k++) {
				for (int j = 0; j < 11; j++) {
					System.out.print(fields[k].field[i][j] + " ");
				}
				System.out.print("\t\t\t\t");
			}
			System.out.print("\n");
		}
	}

	public static double totalValueOfShips(Player player) {
		double valueOfShips = 0;
		int totalShips = 0;

		Ship[] ships = {
				new Admiral(),
				new Kreuzers(),
				new Destroyer(),
				new Submarine()
		};

		for (Ship ship : ships) {
			valueOfShips += ship.getValue() * ship.getRemained();
			totalShips += ship.getRemained();
		}

		player.setTotalShips(totalShips);
		return valueOfShips;
	}

	public int[] validatePosition() {
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
			else if (!this.field[row][column].equals("  "))
				System.out.print("This position is already in use. Select another position.\n");
			else {
				arr[0] = row;
				arr[1] = column;
			}
		}
		return arr;
	}

	public String getPosition(int row, int column) {
		return field[row][column];
	}

	public void conquerPosition(int row, int column) {
		this.field[row][column] = "# ";
	}

	public Ship getShip(int row, int column) {
		return map[row][column];
	}

	public void attackShip(int row, int column) {
		this.map[row][column] = null;
	}

	public Admiral getAdmiral() {
		return admiral;
	}

	public Kreuzers getKreuzers() {
		return kreuzers;
	}

	public Destroyer getDestroyer() {
		return destroyer;
	}

	public Submarine getSubmarine() {
		return submarine;
	}

	public static int getTrap() {
		return trap;
	}
}
