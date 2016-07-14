package decorator;

public class HumburgerDecorator implements Humburger {

	private Humburger hb;

	public HumburgerDecorator(Humburger hb) {
		this.hb = hb;
	}

	@Override
	public String getParts(){
		return hb.getParts();
	}
}
