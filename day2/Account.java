package com.lzw;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public Account(int id, double balance, double annualInterestRate){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getId() {
		return id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(int annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterest() {
		return balance * annualInterestRate;
	}
	
	public void withdraw(double amount) {
		if(balance < amount) {
			System.out.println("Óà¶î²»×ã£¡");
		}else {
			balance -= amount;
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
//	public static void main(String[] args) {
//	 Account a = new Account(1122, 2000, 0.045);
//	 a.withdraw(3000);
//	}
	

}
