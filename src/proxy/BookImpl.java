package proxy;

public class BookImpl implements Book {

	private String auther;

	public BookImpl(String auther) {
		this.auther = auther;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

}
