// “¯––’Àªß£∫ø¥”‡∂Ó+¥Ê«Æ+»°«Æ
package Banking8;

public class Account {
	protected double balance;
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	// ø¥”‡∂Ó
	public double getBalance() {
		return this.balance;
	}
	// ¥Ê«Æ
	public boolean deposit(double amt) {
		this.balance += amt;
		return true;
	}
	// »°«Æ
	public void withdraw(double amt) throws OverdraftException {
		if(this.balance < amt) {
			throw new OverdraftException("”‡∂Ó≤ª◊„", amt - balance);
		}
		this.balance -= amt;
	}
}
