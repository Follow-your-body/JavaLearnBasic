// 存钱（钱+；利息）
package Banking5_2;

public class SavingAccount extends Account{
	private double interestRate;
	/**
	 * SavingsAccount构造器 
	 */
	public SavingAccount(double init_balance, double interestRate) {
		super(init_balance);
		this.interestRate = interestRate;
	}
	
}
