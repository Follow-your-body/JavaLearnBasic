/*
类对象作为形参+匿名类对象
		匿名类对象
			只需要调用一次类的对象时可用
			只能调用一次
		练习PassObject.java Circle.java
*/
package com.lzw;

public class PassObject {
	// 类对象作为成员方法的形参
	static public void printAreas(Circle c, int time) {
		for(int i = 1; i <= time; i++) {
			c.setRadius(i);
			System.out.println(i + "的面积为：" + c.findArea());
		}
	}

	public static void main(String[] args) {
		// 创建匿名类对象
		printAreas(new Circle(), 4);
	}

}
