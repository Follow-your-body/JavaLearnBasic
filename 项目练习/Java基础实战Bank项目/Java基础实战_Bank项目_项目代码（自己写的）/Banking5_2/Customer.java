// 消费者：姓名+账户(检查+存储)
package Banking5_2;

public class Customer {
	private String firstName;
	private String lastName;
	private SavingAccount sa;
	private CheckingAccount ca;
	
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
	public SavingAccount getSaving() {
		return sa;
	}
	public CheckingAccount getChecking() {
		return ca;
	}
	public void setSaving(SavingAccount sa) {
		this.sa = sa; 
	}
	public void setChecking(CheckingAccount ca) {
		this.ca = ca;
	} 
}
