// 取钱时用上账户的存款（可以加+可以不加）
package Banking5_2;

public class CheckingAccount extends Account{
//	private double overdraftProtection;
	protected SavingAccount sa;
	/**
	 * CheckingAccount构造器 1
	 */
	public CheckingAccount(double init_balance, SavingAccount sa) {
		super(init_balance);
		this.sa = sa;
	}
	/**
	 * CheckingAccount构造器 2
	 */
	public CheckingAccount(double init_balance) {
		super(init_balance);
	}
	/** 
	 * 取钱:余额够取或余额+存款够取，取钱可以实现，反之返回false
	 * @param:amt:取的钱数
	 * @return:boolean：取钱是否成功
	 */
	@Override
	public boolean withdraw(double amt) {
		if(balance > amt) {
			balance -= amt;
			return true;
		} else if(sa != null && sa.getBalance() > amt - balance){
			sa.withdraw(amt-balance);
			return true;
		}
		return false;
	}	
}
