/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

package Banking2;


public class TestBanking {

  public static void main(String[] args) {
    Customer customer;
    Account  account;

    System.out.println("Creating the customer Jane Smith.");
    customer  = new Customer("Smith", "Jane");
    System.out.println("Creating her account with a 500.00 balance.");
    account = new Account(500);
    System.out.println("Withdraw 150.00");
    account.withdraw(150);
    System.out.println("Deposit 22.50");
  	account.deposit(22.5);
    System.out.println("Withdraw 47.62");
   	account.deposit(47.62);
    // Print out the final account balance
    System.out.println("Customer [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] has a balance of " + account.getBalance());
  }
}
