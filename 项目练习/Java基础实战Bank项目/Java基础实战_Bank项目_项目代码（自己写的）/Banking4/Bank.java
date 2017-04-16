// 银行：消费者（添加+获取固定消费者+消费者总人数）
package Banking4;

public class Bank {
	private Customer[] customers;
	private int numberOfCustomer;
	public Bank() {
		customers = new Customer[4];
	}	
	/**
	 *  创建新消费者，将新建的消费者加入到customers[]数组中,numberOfCustomer数值加一
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
	 * 获取numberOfCustomer得值（消费者总数量）
	 * @return:numberOfCustomer
	 */
	public int getNumOfCustomers() {
		return numberOfCustomer;
	}
	/**
	 * 获取对应位置的消费者对象
	 * @param:index
	 * @return:Customer[index]
	 */
	public Customer getCustomer(int index) {
		return customers[index];
	}
	

}
