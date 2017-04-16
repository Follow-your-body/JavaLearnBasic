// ���У������ߣ����+��ȡ�̶�������+��������������
package Banking8;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	List<Customer> list = new ArrayList<>();
	private static Bank instance = new Bank();
	private Bank() {
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
		list.add(c);
	}
	/**
	 * ��ȡnumberOfCustomer��ֵ����������������
	 * @return:numberOfCustomer
	 */
	public int getNumOfCustomers() {
		return list.size();
	}
	/**
	 * ��ȡ��Ӧλ�õ������߶���
	 * @param:index
	 * @return:Customer[index]
	 */
	public Customer getCustomer(int index) {
		return list.get(index);
	}
	

}
