package Exam9Optimize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamViewOptimize {
	private char[] answer = new char[1024];

	/**
	 * �ڷ����ж�ȡ���̼���ֵ��ÿ��ֻȡ�������еĵ�һ����ֵ�����жϼ�ֵӦΪa��b��c��d��n��p��f����������Сд��ֵ֮һʱ��������Ϊ��������ֵ��������Բ���
	 */
	public char getUserAction() {
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		char c = ' ';
		try {
			is = System.in;
			os = System.out;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while (true) {
				// System.out.print("����a��b��c��d�е�������������Ϊ��ǰ��Ŀ�Ĵ�;����n��������һ�⣻����p��������һ�⣻����f���������ԡ������룺");
				String str = br.readLine();
				c = str.charAt(0);
				if ("AaBbCcDdNnPpfFYy1234".indexOf(c) != -1) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * �÷�����ʾ����noָ���Ŀ������ݡ�
	 * 
	 * @param no:int
	 */
	public void displayItem(int no) {
		ItemServiceOptimize iso = new ItemServiceOptimize();
		System.out.println(iso.getItem(no).getSubject());
		for(int i = 0; i < 4; i++) {
			System.out.println(iso.getItem(no).getOption()[i]);
		}
	}

	
	
	
	
	/**
	 * ���� getUserAction�������жϵ��û�����a��b��c��d�е������ʱ�������Ϊ��ǰ��Ŀ�Ĵ𰸣�����answer�����У���
	 * ����ʾ���һ��ʱ����n������������ ����ItemService�е�saveAnswer�������д𰸣������ء�
	 */
	public void testExam() {
		ItemService is = new ItemService();
		char c = ' ';
		char[] answer = new char[1024];
		int lastScore = 0;
		

		while (true) {
			c = displayMainMenu();
			
			if (c == '3') {
				break;
			}

			if (c == '2') {
				System.out.println("��һ�εĳɼ�Ϊ��" + lastScore);
			}

			if (c == '1') {
				int index = 0;
				int score = 0;

				System.out.println("\n\n������Ϣ��");
				System.out.println("  ����a��b��c��d�е�������������Ϊ��ǰ��Ŀ�Ĵ�");
				System.out.println("  ����n��������һ��");
				System.out.println("  ����p��������һ��");
				System.out.println("  ����f���������ԡ�\n");

				displayItem(index);
				while (true) {
					System.out.print("����д�Ĵ�Ϊ��" + answer[index]);
					c = getUserAction();
					// ��
					if ("ABCDabcd".indexOf(c) != -1) {
						answer[index] = c;
						System.out.print("����n��������һ�⣻����p��������һ�⣻����f���������ԡ������룺");
						c = getUserAction();
					}
					// next || prior
					if (c == 'n' && index < 9) {
						System.out.println("\n\n\n");
						++index;
						displayItem(index);
					} else if (c == 'p' && index > 0) {
						System.out.println("\n\n\n");
						--index;
						displayItem(index);
					}
					// fΪ����
					if (c == 'f') {
						System.out.print("�Ƿ�������⣬���ȷ�������Y���������N�������룺");
						c = getUserAction();
						if ("Yy".indexOf(c) != -1) {
							is.saveAnswer(answer);

							byte[] rightAnswers = new byte[10];
							for (int i = 0; i < 10; i++) {
								byte[] rightAnswer = is.getItem(i).getAnswer().getBytes();
								rightAnswers[i] = rightAnswer[0];
								if (answer[i] > 'a' && answer[i] < 'z') {
									answer[i] -= 32;
								}
								if (answer[i] == rightAnswer[0]) {
									++score;
								}
								System.out.println(i + ". ��ȷ��Ϊ�� " + (char) rightAnswer[0] + "\t��Ĵ��ǣ�" + answer[i]);
							}
							System.out.println("��ĳɼ�Ϊ��" + score);
							lastScore = score;
							break;
						}
					}
				}
			}
		}
	}
	
	public char displayMainMenu() {
		System.out.println();
		System.out.println();
		System.out.println("-------��ӭʹ�����߿���ϵͳ-------");
		System.out.println();
		System.out.println();
		System.out.println("	1.���뿼��");
		System.out.println("	2.��ʾ�ϴο��Գɼ�");
		System.out.println("	3.�˳�����ϵͳ��");
		System.out.print("	��������˵���ѡ��");
		
		char key = ' ';
		while(true) {
			key = getUserAction();
			if("123".indexOf(key) != -1) {
				break;
			}
			System.out.print("���벻��ȷ�����������룺");
		}
		return key;		
	}

}
