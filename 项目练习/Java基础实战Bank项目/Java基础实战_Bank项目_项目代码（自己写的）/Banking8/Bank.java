// 银行：消费者（添加+获取固定消费者+消费者总人数）
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
	 *  创建新消费者，将新建的消费者加入到customers[]数组中,numberOfCustomer数值加一
	 * @param f
	 * @param l
	 * @return:void
	 */
	public void addCustomer(String f, String l) {
		Customer c = new Customer(f, l);
		list.add(c);
	}
	/**
	 * 获取numberOfCustomer得值（消费者总数量）
	 * @return:numberOfCustomer
	 */
	public int getNumOfCustomers() {
		return list.size();
	}
	/**
	 * 获取对应位置的消费者对象
	 * @param:index
	 * @return:Customer[index]
	 */
	public Customer getCustomer(int index) {
		return list.get(index);
	}
	

}
