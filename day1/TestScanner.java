/*
 * ��������С���ĳɼ�
 * 100������һ��BMW
 * (80,99]:����һ̨iphone
 * (60,79]:����һ���ο���
 * (,59]:ʲô����Ҳû��
 * */
package com.lzw;
import java.util.Scanner;

class TestScanner 
{
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("������С���ĳɼ���");
		int score = (int)s.nextInt();
		if(score == 100) {
			System.out.print("����һ��BMW");
		}else if(score > 80) {
			System.out.print("����һ̨iphone");
		}else if(score > 60) {
			System.out.print("����һ���ο���");
		}else {
			System.out.print("ʲô����Ҳû��");
		}
	}
	
}

