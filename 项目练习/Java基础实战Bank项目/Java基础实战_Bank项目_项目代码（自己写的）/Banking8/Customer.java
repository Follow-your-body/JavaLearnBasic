// 消费者：姓名+账户
package Banking8;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	List<Account> list = new ArrayList<>();

	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void addAccount(Account acct) {
		list.add(acct);
	}

	public Account getAccount(int index) {
		return list.get(index);
	}

	public int getNumOfAccounts() {
		return list.size();
	}
}
