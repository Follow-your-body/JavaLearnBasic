/*
 * 键盘输入小明的成绩
 * 100：奖励一辆BMW
 * (80,99]:奖励一台iphone
 * (60,79]:奖励一本参考书
 * (,59]:什么奖励也没有
 * */
package com.lzw;
import java.util.Scanner;

class TestScanner 
{
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("请输入小明的成绩：");
		int score = (int)s.nextInt();
		if(score == 100) {
			System.out.print("奖励一辆BMW");
		}else if(score > 80) {
			System.out.print("奖励一台iphone");
		}else if(score > 60) {
			System.out.print("奖励一本参考书");
		}else {
			System.out.print("什么奖励也没有");
		}
	}
	
}

