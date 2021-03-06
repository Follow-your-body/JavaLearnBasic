// 给一个账户加一个弥补款（可以加+可以不加）
package Banking5;

public class CheckingAccount extends Account{
	private double overdraftProtection;
	/**
	 * CheckingAccount构造器 1
	 */
	public CheckingAccount(double init_balance, double overdraftProtection) {
		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}
	/**
	 * CheckingAccount构造器 2
	 */
	public CheckingAccount(double init_balance) {
		super(init_balance);
	}
	/* 取钱:余额够取或余额+弥补款够取，取钱可以实现，反之返回false
	 * @param:amt:取的钱数
	 * @return:boolean：取钱是否成功
	 */
	@Override
	public boolean withdraw(double amt) {
		if(balance > amt) {
			balance -= amt;
			return true;
		} else if(balance < amt && (balance + this.overdraftProtection) > amt){
			balance -= amt;
			return true;
		}
		return false;
	}	
}
