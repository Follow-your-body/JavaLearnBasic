/*��1-100֮�������ż����
 * �Ӽ����ж�ȡ������ȷ�������������ж϶���������͸����ĸ���������Ϊ0ʱ��������
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
		System.out.println("1-100֮�������ż����:" + count);
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
		System.out.println("������������棬�����ĸ���Ϊ��" + positiveNum);
		System.out.println("������������棬�����ĸ���Ϊ��" + negitiveNum);
	}

}
