package com.winstar.exam.view;

import java.util.Scanner;

import com.winstar.exam.service.ItemService;

public class ExamView {
	char[] answer = new char[10];// ????
	ItemService service = new ItemService();

	// ��Ҫ�ж������ֵ�ǲ��� A,B,C,D,N,P,
	// ����ǣ�����������ַ�
	// ������Ǿ����û���������
	// ??��׳�������⣬���ֱ������س�����
	public char getUserAction() {
		Scanner scan = new Scanner(System.in);
		char[] keys = { 'A', 'B', 'C', 'D', 'N', 'P','F'};
		char ch = '\u0000';
		while (scan.hasNext()) {
			String str = scan.next();
			ch = str.toUpperCase().charAt(0);
			for (char key : keys) {
				if (ch == key) {
					return ch;// ���ص��Ǵ�д���ַ�
				}
			}
			System.out.println("����������");
		}
		return ch;
	}

	/*
	 * ��ʾÿһ�����}
	 */
	public void displayItem(int no) {

		System.out.println(service.getItem(no));
		if (answer[no - 1] != '\u0000') {
			System.out.println(answer[no - 1]);
		}
	}

	/*
	 * 
	 */
	public void testExam() {
		// 1.��ʾ��һ�⣬ѡ��n��ʾ��һ��ѡ��p��ʾ��һ��
		// 2.
		int itemNo = 1;
		displayWelcome();
		while (true) {

			displayItem(itemNo);
			char key = getUserAction();
			switch (key) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
				answer[itemNo - 1] = key;
			case 'N':// ��ʾ��һ��
				if (itemNo >= 10) {
					System.out.println("�������������");
					service.saveAnswer(answer);
					return;
				}
				itemNo++;
				break;
			case 'P':// ��ʾ��һ��
				if (itemNo <= 1) {
					System.out.println("��ǰ�Ѿ��ǵ�һ��");
				} else {
					itemNo--;
				}
				break;

			}
		}

	}

	private void displayWelcome() {
		System.out.println();
		System.out.println();
		System.out.println("----------��ӭ���뿼��----------");
		System.out.println();
		System.out.println("   ʹ�����°������п���:");
		System.out.println();
		System.out.println("        A-D:ѡ��ָ����");
		System.out.println("        P:��ʾ��һ��");
		System.out.println("        N:��ʾ��һ��");
		System.out.println("        F����������");
		System.out.println("         �밴n�����뿼��");
		while(true){
			char key=getUserAction();
			if(key=='N'){
				break;
			}else{
				System.out.println("�������벻�Ϸ���������n/N");
			}
		}

	}

}
