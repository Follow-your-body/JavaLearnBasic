/*
成员方法的重载
	同一个类名中方法名相同，形参的个数或者类型不同（顺序不同也算）
	注意：与重载方法的返回类型没有关系（也就是说返回值可以不同）
	练习：TestOverloading.java

 * 三个重载方法
 * 第一个：一个int形参，输出形参平方结果
 * 第二个：两个int形参，分别输出形参平方结果
 * 第三个：一个String形参，输出形参字符串
 * */
package com.lzw;

public class TestOverloading {
	static public void mOL(int i) {
		System.out.println("第一个重载函数，形参为int类型，个数为1，平方的结果为：" + i * i);
	}
	
	static public void mOL(int i, int j) {
		System.out.println("第二个重载函数，形参为int类型，个数为2，第一个形参的平方的结果为：" + i * i
				+ ",第二个形参的平方的结果为：" + j * j);
	}
	
	static public void mOL(String i) {
		System.out.println("第三个重载函数，形参为Sting类型，个数为1，形参为：" + i);
	}

	public static void main(String[] args) {
		mOL(2);
		mOL(1,3);
		mOL("danay");
	}

}
