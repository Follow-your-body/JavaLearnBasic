// ȡǮʱ�����˻��Ĵ����Լ�+���Բ��ӣ�
package Banking5_2;

public class CheckingAccount extends Account{
//	private double overdraftProtection;
	protected SavingAccount sa;
	/**
	 * CheckingAccount������ 1
	 */
	public CheckingAccount(double init_balance, SavingAccount sa) {
		super(init_balance);
		this.sa = sa;
	}
	/**
	 * CheckingAccount������ 2
	 */
	public CheckingAccount(double init_balance) {
		super(init_balance);
	}
	/** 
	 * ȡǮ:��ȡ�����+��ȡ��ȡǮ����ʵ�֣���֮����false
	 * @param:amt:ȡ��Ǯ��
	 * @return:boolean��ȡǮ�Ƿ�ɹ�
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
