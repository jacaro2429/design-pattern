package decorator;

public class Client {

	public static void main(String[] args) {

		Humburger hb = new AddCheese(new AddCheese(new AddShengcai(
				new ChickenHumburger())));

		System.out.println(hb.getParts());
	}
}
