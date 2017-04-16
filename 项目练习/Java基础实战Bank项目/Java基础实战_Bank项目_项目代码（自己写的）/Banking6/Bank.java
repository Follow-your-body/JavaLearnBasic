// ���У������ߣ����+��ȡ�̶�������+��������������
package Banking6;

public class Bank {
	private Customer[] customers;
	private int numberOfCustomer;
	private static Bank instance = new Bank();
	private Bank() {
		customers = new Customer[4];
	}	
	public static Bank getBanking() {
		return instance;
	}
	/**
	 *  �����������ߣ����½��������߼��뵽customers[]������,numberOfCustomer��ֵ��һ
	 * @param f
	 * @param l
	 * @return:void
	 */
	public void addCustomer(String f, String l) {
		Customer c = new Customer(f, l);
		customers[numberOfCustomer] = c;
		numberOfCustomer++;
	}
	/**
	 * ��ȡnumberOfCustomer��ֵ����������������
	 * @return:numberOfCustomer
	 */
	public int getNumOfCustomers() {
		return numberOfCustomer;
	}
	/**
	 * ��ȡ��Ӧλ�õ������߶���
	 * @param:index
	 * @return:Customer[index]
	 */
	public Customer getCustomer(int index) {
		return customers[index];
	}
	

}
