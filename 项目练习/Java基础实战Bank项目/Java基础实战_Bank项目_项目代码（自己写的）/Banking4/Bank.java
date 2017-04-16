// ���У������ߣ����+��ȡ�̶�������+��������������
package Banking4;

public class Bank {
	private Customer[] customers;
	private int numberOfCustomer;
	public Bank() {
		customers = new Customer[4];
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
