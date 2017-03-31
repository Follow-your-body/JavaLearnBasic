/*求1-100之间的所有偶数和
 * 从键盘中读取个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序
 * */
package com.lzw;
import java.util.Scanner;

public class TestWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		evenNumberAdd();
		keyBoard();

	}
	
	public static void evenNumberAdd() {
		int i = 1;
		int count = 0;
		while(i <= 100) {
			if(i % 2 == 0) {
				count += i; 
			}
			i++;
		}
		System.out.println("1-100之间的所有偶数和:" + count);
	}
	
	public static void keyBoard() {
		Scanner s = new Scanner(System.in);
		int num = 1;
		int positiveNum = -1;
		int negitiveNum = 0;
		while(num != 0) {
			num = (int)s.nextInt();
			if(num > 0) {
				positiveNum++;
			}else {
				negitiveNum++;
			}
		}
		System.out.println("输入的整数里面，正数的个数为：" + positiveNum);
		System.out.println("输入的整数里面，负数的个数为：" + negitiveNum);
	}

}
