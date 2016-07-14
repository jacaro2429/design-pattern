package decorator;

public class AddCheese extends HumburgerDecorator {

	public AddCheese(Humburger hb) {
		super(hb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParts() {
		return super.getParts() + " + Cheese";
	}

}
