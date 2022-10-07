public abstract class Ship {
	private String shipName;
	private int id;
	private double value;
	private int remained;

	public String getSHipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getRemained() {
		return remained;
	}

	public void setRemained(int remained) {
		this.remained = remained;
	}
}

class Admiral extends Ship {
	public Admiral() {
		this.setShipName("Admiral XXXX");
		this.setId(4);
		this.setValue(4.0);
		this.setRemained(1);
	}
}

class Kreuzers extends Ship {
	public Kreuzers() {
		this.setShipName("Kreuzers XXX");
		this.setId(3);
		this.setValue(3.0);
		this.setRemained(2);
	}
}

class Destroyer extends Ship {
	public Destroyer() {
		this.setShipName("Destroyer XX");
		this.setId(2);
		this.setValue(2.0);
		this.setRemained(3);
	}
}

class Submarine extends Ship {
	public Submarine() {
		this.setShipName("Submarine X");
		this.setId(1);
		this.setValue(1.0);
		this.setRemained(4);
	}
}
