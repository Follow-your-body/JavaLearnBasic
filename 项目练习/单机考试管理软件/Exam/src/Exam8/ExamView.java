package Exam8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamView {
	private char[] answer;
	
	/**
	 *�ڷ����ж�ȡ���̼���ֵ��ÿ��ֻȡ�������еĵ�һ����ֵ�����жϼ�ֵӦΪa��b��c��d��n��p��f����������Сд��ֵ֮һʱ��������Ϊ��������ֵ��������Բ���
	 * */
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
			while(true) {
//				System.out.print("����a��b��c��d�е�������������Ϊ��ǰ��Ŀ�Ĵ�;����n��������һ�⣻����p��������һ�⣻����f���������ԡ������룺");
				String str = br.readLine();
				c = str.charAt(0);			
				if("AaBbCcDdNnPpfFYy".indexOf(c) != -1) {
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
	 * @param no:int
	 * */
	public void displayItem(int no) {
		ItemService is = new ItemService();
		System.out.println(is.getItem(no).getSubject());
		System.out.println(is.getItem(no).getOptionA());
		System.out.println(is.getItem(no).getOptionB());
		System.out.println(is.getItem(no).getOptionB());
		System.out.println(is.getItem(no).getOptionC());
		System.out.println(is.getItem(no).getOptionD());
	}
	
	
	/**
	 * ���� getUserAction�������жϵ��û�����a��b��c��d�е������ʱ�������Ϊ��ǰ��Ŀ�Ĵ𰸣�����answer�����У���
	 * ����ʾ���һ��ʱ����n������������ ����ItemService�е�saveAnswer�������д𰸣������ء�
	 * */
	public int testExam() {
		ItemService is = new ItemService();
		answer = new char[1024];
		int index = 0;
		int score = 0;
		
		System.out.println("������Ϣ�����û�����a��b��c��d�е������ʱ�������Ϊ��ǰ��Ŀ�Ĵ𰸣�"
				+ "���û�����nʱ��������һ�⣻���û�����pʱ��������һ�⣻����ʾ���һ��ʱ����n�˳����ԣ�\n");
		
		displayItem(index);
		while(true) {
			System.out.println("����д�Ĵ�Ϊ��" + answer[index]);
			System.out.print("����a��b��c��d�е�������������Ϊ��ǰ��Ŀ�Ĵ�;����n��������һ�⣻����p��������һ�⣻����f���������ԡ������룺");
			char c = getUserAction();
			// ��
			if("abcd".indexOf(c) != -1) {
				answer[index] = c;
			} 
			// next || prior
			if(c == 'n' && index < 9) {
				System.out.println("\n\n\n");
				++index;
				displayItem(index);
			} else if(c == 'p' && index > 0) {
				System.out.println("\n\n\n");
				--index;
				displayItem(index);
			} 
			// fΪ����
			if(c == 'f') {
				System.out.print("�Ƿ�������⣬���ȷ�������Y���������N�������룺");
				c = getUserAction();
				if("Yy".indexOf(c) != -1){
					is.saveAnswer(answer);
					
					byte[] rightAnswers = new byte[10]; 
					for(int i = 0; i < 10; i++) {
						byte[] rightAnswer = is.getItem(i).getAnswer().getBytes(); 
						rightAnswers[i] = rightAnswer[0];
						if(answer[i] == rightAnswer[0]) {
							++score;
						}
						System.out.println(i + ". ��ȷ��Ϊ�� " + (char)rightAnswer[0] + "\t��Ĵ��ǣ�" + answer[i]);
					}
					System.out.println("��ĳɼ�Ϊ��" + score);
					break;
				}
			}
		}
		return score;
	}


}
