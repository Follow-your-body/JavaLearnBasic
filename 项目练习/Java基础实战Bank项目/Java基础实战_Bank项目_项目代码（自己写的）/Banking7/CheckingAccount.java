// ��һ���˻���һ���ֲ�����Լ�+���Բ��ӣ�
package Banking7;

public class CheckingAccount extends Account{
	private double overdraftProtection;
	/**
	 * CheckingAccount������ 1
	 */
	public CheckingAccount(double init_balance, double overdraftProtection) {
		super(init_balance);
		this.overdraftProtection = overdraftProtection;
	}
	/**
	 * CheckingAccount������ 2
	 */
	public CheckingAccount(double init_balance) {
		super(init_balance);
	}
	/* ȡǮ:��ȡ�����+�ֲ��ȡ��ȡǮ����ʵ�֣���֮����false
	 * @param:amt:ȡ��Ǯ��
	 * @return:boolean��ȡǮ�Ƿ�ɹ�
	 */
	@Override
	public void withdraw(double amt) throws OverdraftException {
		if(this.overdraftProtection == 0) {
			throw new OverdraftException("no overdraft protection", 0);
		}
		if(balance > amt) {
			balance -= amt;
		} else if(balance < amt && (balance + this.overdraftProtection) > amt){
			balance -= amt;
		}
		throw new OverdraftException("Insufficient funds for overdraft protection", amt - balance);
	}	
}
