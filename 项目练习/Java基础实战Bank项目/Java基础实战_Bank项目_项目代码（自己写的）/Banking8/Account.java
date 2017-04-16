// �����˻��������+��Ǯ+ȡǮ
package Banking8;

public class Account {
	protected double balance;
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	// �����
	public double getBalance() {
		return this.balance;
	}
	// ��Ǯ
	public boolean deposit(double amt) {
		this.balance += amt;
		return true;
	}
	// ȡǮ
	public void withdraw(double amt) throws OverdraftException {
		if(this.balance < amt) {
			throw new OverdraftException("����", amt - balance);
		}
		this.balance -= amt;
	}
}
