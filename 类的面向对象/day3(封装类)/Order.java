/*
String类型
	equals()方法
		只能调用引用类型对象（应用对象的对应数值+地址值是否相同）
		比较引用变量的数值是否相等
*/
package com.lzw;

public class Order {
	
	private int orderld;
	private String orderName;
	
	public Order(int orderld, String orderName) {
		this.orderld = orderld;
		this.orderName = orderName;
	}
	
	public void SetOrderld(int orderld) {
		this.orderld = orderld;
	}
	
	public int getOrderld() {
		return orderld;
	}
	
	public void SetOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public String getOrderName() {
		return orderName;
	} 
	
	// equals方法定义
	public boolean equals(Object obj1, Object obj2) {
		return obj1 == obj2;
	}
	
	// equals方法充载
	public boolean equals(int a1, int a2) {
		return a1 == a2;
	}
	
	// equals方法充载
	public boolean equals(String str1, String str2) {
		return str1 == str2;
	}
	
	public static void main(String[] args) {
		Order o1 = new Order(1, "danay");
		Order o2 = new Order(1, "danay");
		// 引用对象类型的地址不同
		System.out.println(o1.equals(o1,  o2));  
		// 基本对象类型的数值
		System.out.println(o1.equals(o1.orderld,  o2.orderld));
		// 引用对象类型的地址
		System.out.println(o1.equals(o1.orderName,  o2.orderName));
	}

}
