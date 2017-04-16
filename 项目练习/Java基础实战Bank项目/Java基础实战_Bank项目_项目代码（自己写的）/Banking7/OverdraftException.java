package Banking7;

public class OverdraftException extends Exception{
	private double deficit;
	
	// ����
	public double getDeficit() {
		return deficit;
	}

	public OverdraftException(String str, double deficit) {
		super(str);
		this.deficit = deficit;
	}
	
}
