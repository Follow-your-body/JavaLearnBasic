// ��һ���˻���һ���ֲ�����Լ�+���Բ��ӣ�
package Banking6;

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
