package decorator;

public class AddShengcai extends HumburgerDecorator{

	public AddShengcai(Humburger hb) {
		super(hb);
	}
	
	@Override
	public String getParts(){
		return super.getParts() + " + shengcai";
	}
	

}
