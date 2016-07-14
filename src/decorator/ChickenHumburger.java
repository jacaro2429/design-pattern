package decorator;

public class ChickenHumburger implements Humburger {

	private String parts = "Chicken";

	@Override
	public String getParts() {
		return this.parts;
	}

}
