/*ʹ��Ƕ��ѭ��
 * ����žų˷���
 * ���1-100֮�����е�����
 * break:������һ��ѭ��
 * continue��������һ��ѭ������ѭ�������ٴ�����
 * */
package com.lzw;

public class Multinest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiplicationTable();
		primeNum();

	}
		
	public static void multiplicationTable() {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}
	
	public static void primeNum() {
		for (int i = 1; i <= 100; i++) {
			for(int j = 2; j <= i / 2; j++) {
				if(i % j == 0) {
					break;
				}else if(j == i / 2){
					System.out.println("1-100֮���ָ���У�" + i);
				}
			}
		}
	}

}
