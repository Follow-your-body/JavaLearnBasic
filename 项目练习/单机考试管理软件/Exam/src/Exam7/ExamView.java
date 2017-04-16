package Exam7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamView {
	private char[] answer;
	
	/**
	 *�ڷ����ж�ȡ���̼���ֵ��ÿ��ֻȡ�������еĵ�һ����ֵ�����жϼ�ֵӦΪa��b��c��d��n��p����������Сд��ֵ֮һʱ��������Ϊ��������ֵ��������Բ���
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
				System.out.print("���������ݣ�");
				String str = br.readLine();
				c = str.charAt(0);			
				if("AaBbCcDdNnPp".indexOf(c) != -1) {
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
		System.out.println(is.getItem(no));
	}
	
	
	/**
	 * ���� getUserAction�������жϵ��û�����a��b��c��d�е������ʱ�������Ϊ��ǰ��Ŀ�Ĵ𰸣�����answer�����У���
	 * ����ʾ���һ��ʱ����n������������ ����ItemService�е�saveAnswer�������д𰸣������ء�
	 * */
	public String testExam() {
		ItemService is = new ItemService();
		answer = new char[1024];
		int indexAnswer = 0;
		int indexItem = 0;
		displayItem(indexItem);
		while(true) {
			char c = getUserAction();
			if(c == 'n' && indexItem < 9) {
				displayItem(++indexItem);
			} else if(c == 'n' && indexItem == 9) {
				is.saveAnswer(answer);
				break;
			} else if(c == 'p' && indexItem > 0) {
				displayItem(--indexItem);
			} else if("abcd".indexOf(c) != -1) {
				answer[indexAnswer++] = c;
			} else if(c == 'n' && indexItem == 9) {
				is.saveAnswer(answer);
				break;
			}
		}
		return new String(answer, 0, answer.length);
	}


}
