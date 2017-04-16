package com.winstar.exam.view;

import java.util.Scanner;

import com.winstar.exam.service.ItemService;

public class ExamView {
	ItemService service = new ItemService();
	char[] answer = new char[service.getTotal()];

	// ��Ҫ�ж������ֵ�ǲ��� A,B,C,D,N,P,
	// ����ǣ�����������ַ�
	// ������Ǿ����û���������
	public char getUserAction() {
		Scanner scan = new Scanner(System.in);
		char[] keys = { 'A', 'B', 'C', 'D', 'N', 'P', 'F', 'Y', '1', '2', '3' };
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
		// 2.ѡ��abcd��ִ�д���
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
				if (itemNo >= service.getTotal()) {
					service.saveAnswer(answer);
					showAnswers(answer);
					System.out.println("�������������");
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
			case 'F':
				// �ж�һ���Ƿ�Ҫ���������ȷ�Ͻ���
				if (isYN()) {
					// �����
					service.saveAnswer(answer);
					// �з֣���ʾ��ȷ�𰸼�����
					showAnswers(answer);
					return;
				}
				break;

			}
		}

	}

	private void showAnswers(char[] answer) {
		System.out.println("���\t��ȷ��\t�û�ѡ��");
		int score = 0;
		for (int i = 0; i < answer.length; i++) {
			char rightAnswer = service.getItem(i + 1).getAnswer().charAt(0);
			if (rightAnswer == answer[i]) {
				score += 100 / answer.length;
			}
			System.out.println("��" + (i + 1) + "��\t" + rightAnswer + "\t"
					+ answer[i]);
		}
		System.out.println("���÷֣�" + score);
	}

	private boolean isYN() {
		System.out.println("��ȷ��Ҫ���������ȷ��������y����������n");
		while (true) {
			char key = getUserAction();
			if (key != 'Y' && key != 'N') {
				continue;
			}
			boolean b = (key == 'Y');
			return (b);

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
		while (true) {
			char key = getUserAction();
			if (key == 'N') {
				break;
			} else {
				System.out.println("�������벻�Ϸ���������n/N");
			}
		}

	}

	private void displayMainMenu() {
		System.out.println();
		System.out.println();
		System.out.println("-------��ӭʹ�����߿���ϵͳ-------");
		System.out.println();
		System.out.println("       1 ���뿼��");
		System.out.println("       2 �鿴�ɼ�");
		System.out.println("       3 ϵͳ�˳�");
		System.out.println();
		System.out.print("       ��ѡ��...");
	}

	public void mainMenu() {
		while (true) {
			displayMainMenu();
			char key = getUserAction();
			switch (key) {
			case '1':// ���뿼��
				testExam();
				break;
			case '2':
				answer = service.readAnswer();
				showAnswers(answer);
				break;
			case '3':
				if(isYN()){
					return;
				}
				break;
			}
		}
	}

}
