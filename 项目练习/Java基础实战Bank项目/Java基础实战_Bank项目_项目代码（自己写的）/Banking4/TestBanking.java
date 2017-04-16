/**
 * 对象的使用
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

package Banking4;

public class TestBanking {

  public static void main(String[] args) {
    Bank bank = new Bank();

    // Add Customer Jane, Simms
	bank.addCustomer("Simms", "Simms");
    //Add Customer Owen, Bryant
	bank.addCustomer("Bryant", "Owen");
    // Add Customer Tim, Soley
	bank.addCustomer("Soley", "Tim");
    // Add Customer Maria, Soley
	bank.addCustomer("Soley", "Maria");
    for ( int i = 0; i < bank.getNumOfCustomers(); i++ ) {
      Customer customer = bank.getCustomer(i);

      System.out.println("Customer [" + (i+1) + "] is "
			 + customer.getLastName()
			 + ", " + customer.getFirstName());
    }
  }
}
