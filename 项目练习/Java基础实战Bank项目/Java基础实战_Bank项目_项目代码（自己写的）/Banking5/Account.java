// 银行账户：看余额+存钱+取钱
package Banking5;

public class Account {
	protected double balance;
	public Account(double init_balance) {
		this.balance = init_balance;
	}
	// 看余额
	public double getBalance() {
		return this.balance;
	}
	// 存钱
	public boolean deposit(double amt) {
		this.balance += amt;
		return true;
	}
	// 取钱
	public boolean withdraw(double amt) {
		if(this.balance < amt) {
			return false;
		}
		this.balance -= amt;
		return true;
	}
}
