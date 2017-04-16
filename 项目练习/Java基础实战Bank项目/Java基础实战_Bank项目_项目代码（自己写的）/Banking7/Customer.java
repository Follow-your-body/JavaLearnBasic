// 消费者：姓名+账户
package Banking7;

public class Customer {
	private String firstName;
	private String lastName;
	private Account[] accounts;
	private int numberOfAccount;
	
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
		accounts = new Account[5];
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void addAccount(Account acct ) {
		accounts[numberOfAccount] = acct;
		numberOfAccount++;
	}
	public Account getAccount(int index) {
		return accounts[index];
	}
	public int getNumOfAccounts() {
		return this.numberOfAccount;
	}
}
