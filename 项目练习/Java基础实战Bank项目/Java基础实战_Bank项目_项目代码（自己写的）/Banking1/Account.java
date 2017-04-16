package Banking1;

public class Account {
	private double balance;
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	// ”‡∂Ó
	public double getBalance() {
		return this.balance;
	}
	// ¥Ê«Æ
	public void deposit(double amt) {
		this.balance += amt;
	}
	// »°«Æ
	public void withdraw(double amt) {
		this.balance -= amt;
	}
}
