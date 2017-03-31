/*
super关键字
		可用于访问父类中的属性+成员方法（同名时，可以用来区分）
		可用于在子类构造方法中调用父类的构造器
		代表父类空间的标识
		1，当子类和父类中有同名的属性时，可以通过“supper。此属性”显式的调用父类中声明的属性
		若想调用调用子类中同名的属性“this.此属性”
		2，当子类重写父类的方法以后，在子类中若想再显式的调用父类的被重写的方法，就需要使用
		“super.方法名”
		3，super修饰构造器，通过在子类中使用“super（形参列表）”来显式的调用父类中指定的构造器
			在构造器内部，“super（形参列表）”必须声明在首行
			在构造器内部，“this(形参列表)”或“super(形参列表)”只能出现一个
			在构造器内部，不显式的调用“this(形参列表)”或“super(形参列表)”其中任何一个，默认调用的时父类空参的构造器
			建议：最好构造一个空参的构造器
*/
package com.lzw;

public class CheckAccount extends Account{
	
	private int overdraft;
	
	public CheckAccount(int id, double balance, double annualInterestRate, int overdraft) {  // 创建子类自己的构造函数
		super(id, balance, annualInterestRate);   // 继承父类构造函数
		this.overdraft = overdraft;
	}
	
	public void withdraw(double amount) {
		if(super.getBalance() < amount) {  //调用父类的方法：super.方法
			System.out.println("余额不足！");
		}else {
			super.setBalance((super.getBalance() - amount));
		}
	}

	public static void main(String[] args){
		CheckAccount ca = new CheckAccount(1122, 20000, 0.045, 5000);
		ca.withdraw(5000);
		System.out.println("账户余额为：" + ca.getBalance() + "可透支金额为： "+ ca.overdraft);
		ca.withdraw(3000);
		System.out.println("账户余额为：" + ca.getBalance() + "可透支金额为： "+ ca.overdraft);
	}
}
