/*
	多态性
		中面向对象中最重要的概念，在Java中有两种体现
			方法的重载和重写
			对象对象的多态性
		子类对象的多态性的前提
			要有类的继承
			子类对父类方法的重写
		程序运行时分为编译状态和运行状态
			对于多态性来说，编译时看左边，将此引用变量理解为父类的类型
			运行时看右边，关注于真正对象的尸体，子类的对象，那么执行的方法就是子类重写的
	练习：Student2.java Person2.java Graduate.java TestInstance.java
*/
package com.lzw;

public class Student2 extends Person2{
	
	protected String school = "pku";
	public String getInfo() {
		return "Name:" + name + "\tage:" + age + "\tschool:" + school;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
