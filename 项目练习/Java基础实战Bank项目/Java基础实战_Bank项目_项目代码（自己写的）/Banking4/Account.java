// �����˻��������+��Ǯ+ȡǮ
package Banking4;

public class Account {
	private double balance;
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
	public boolean withdraw(double amt) {
		if(this.balance < amt) {
			return false;
		}
		this.balance -= amt;
		return true;
	}
}
