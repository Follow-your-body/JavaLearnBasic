/*
String����
	equals()����
		ֻ�ܵ����������Ͷ���Ӧ�ö���Ķ�Ӧ��ֵ+��ֵַ�Ƿ���ͬ��
		�Ƚ����ñ�������ֵ�Ƿ����
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
	
	// equals��������
	public boolean equals(Object obj1, Object obj2) {
		return obj1 == obj2;
	}
	
	// equals��������
	public boolean equals(int a1, int a2) {
		return a1 == a2;
	}
	
	// equals��������
	public boolean equals(String str1, String str2) {
		return str1 == str2;
	}
	
	public static void main(String[] args) {
		Order o1 = new Order(1, "danay");
		Order o2 = new Order(1, "danay");
		// ���ö������͵ĵ�ַ��ͬ
		System.out.println(o1.equals(o1,  o2));  
		// �����������͵���ֵ
		System.out.println(o1.equals(o1.orderld,  o2.orderld));
		// ���ö������͵ĵ�ַ
		System.out.println(o1.equals(o1.orderName,  o2.orderName));
	}

}
