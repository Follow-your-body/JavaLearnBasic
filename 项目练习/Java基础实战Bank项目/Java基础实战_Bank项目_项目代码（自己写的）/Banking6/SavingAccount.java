// ��Ǯ��Ǯ+����Ϣ��
package Banking6;

public class SavingAccount extends Account{
	private double interestRate;
	/**
	 * SavingsAccount������ 
	 */
	public SavingAccount(double init_balance, double interestRate) {
		super(init_balance);
		this.interestRate = interestRate;
	}
	
}
