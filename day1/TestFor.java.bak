/*
 * 1-150循环车输出
	 * 在3的倍数杭商打印出Foo
	 * 在5的倍数杭商打印出Biz
	 * 在3的倍数杭商打印出Bia
 * 输出1-100所有奇数的和
 * 计算1-100中是7的整数倍的个数及其总和
 * 输出100-999中所有水仙花数 153 = 1*1*1+3*3*3+5*5*5
 * */
package com.lzw;

public class FooBizBaz {

	public static void main(String[] args) {
		foo();
		odd();	
		sevenTimes();
		narcissus();
	}
	
	public static void foo() {
		 for (int i = 1; i <= 150; i++) {
				System.out.print(i);
				if(i % 3 == 0) {
					System.out.println("Foo");				
				}else if(i % 5 == 0) {
					System.out.println("Biz");				
				}else if(i % 7 == 0) {
					System.out.println("Bia");				
				}else {
					System.out.println();				
				}
		 }
	 }
	
	 public static void odd() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 2 != 0) {
				sum = sum + i;				
			}
		}
		System.out.println("1-100所有奇数的和: " + sum);
	}
	 
	 public static void sevenTimes() {
		 int sum = 0;
		 int times = 0;
			for (int i = 1; i <= 100; i++) {
				if(i % 7 == 0) {
					sum = sum + i;	
					times++;
				}
			}
			System.out.println("1-100所有是7的整数倍的个数: " + times);
			System.out.println("1-100所有是7的整数倍的总和: " + sum);		 
	 }
	 
	 public static void narcissus() {
		 int digits = 0;
		 int tens = 0;
		 int hundreds = 0;
			for (int i = 100; i <= 999; i++) {
				digits = (i % 100)%10;
				tens = (i/10)%10;
				hundreds = i/100;				
				if(i == digits*digits*digits + tens*tens*tens + hundreds*hundreds*hundreds) {
					System.out.println("水仙花有: " + i);
				}
			}
	 }	 

}
