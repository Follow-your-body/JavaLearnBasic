package Exam9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamView {
	private char[] answer;

	/**
	 * �ڷ����ж�ȡ���̼���ֵ��ÿ��ֻȡ�������еĵ�һ����ֵ�����жϼ�ֵӦΪa��b��c��d��n��p��f/1/2/3/y/n����������Сд��ֵ֮һʱ��������Ϊ��������ֵ��������Բ���
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
		ItemService is = new ItemService();
		System.out.println(is.getItem(no).getSubject());    // �����֪������ѡ����Ǽ���Ӧ�� ��ô�죿(��������Ҳ�ǿ��Ե�)
		System.out.println(is.getItem(no).getOptionA());
		System.out.println(is.getItem(no).getOptionB());
		System.out.println(is.getItem(no).getOptionB());
		System.out.println(is.getItem(no).getOptionC());
		System.out.println(is.getItem(no).getOptionD());
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
			System.out.println("\n\n���˵�\n 1.���뿼��\n 2.��ʾ�ϴο��Գɼ�\n 3.�������˵�\n 4.�˳�����ϵͳ��");   //TODO д�ɶ��У��ȽϺÿ�
			System.out.print("��������˵���ѡ��");
			c = getUserAction();     // Ŀ¼�����������һ����������������ȽϷ��㣩
			if (c == '4') {
				break;
			}

			if (c == '3') {
			}

			if (c == '2') {
				System.out.println("��һ�εĳɼ�Ϊ��" + lastScore);
			}

			if (c == '1') {
				int index = 0;
				int score = 0;
				
				//TODO д�ɶ��У��ȽϺÿ�
				System.out.println("\n\n������Ϣ��\n  ����a��b��c��d�е�������������Ϊ��ǰ��Ŀ�Ĵ�;\n  ����n��������һ�⣻\n  ����p��������һ�⣻\n  ����f���������ԡ�\n");

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

}
