/* 1，面向对象的编程关注于类的设计
 * 2，设计类就是设计类的成员
 * 3，基本的类的成员：属相&方法
 * */
package com.lzw;

public class TestPerson {
	// 1,属性(成员变量)
	String name;
	int age;
	boolean sex;
	
	// 2，方法（成员方法）
	public void eat() {
		int fruit; // 局部变量
		System.out.println("人吃饭");
	}
	public void sleep() {
		System.out.println("人睡觉");
	}
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		TestPerson tp = new TestPerson();  // 创建类的对象
		tp.age = 12;            // 调用实现相应的功能（成员变量）
		tp.name = "danay";		
	}

}
