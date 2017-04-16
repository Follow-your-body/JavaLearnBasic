package Exam6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamView {
	
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
	 * ��ʼʱ������ displayItem��ʾ�����1�⣻
		���� getUserAction�������жϵ��û�����nʱ����ʾ��һ�⣻���û�����pʱ����ʾ��һ�⣨�����ǰ���ǵ�1��ʱ����
		�ڵ�ǰΪ���һ��ʱ����n���������������ء�

	 * */
	public void testExam() {
		int index = 0;
		displayItem(index);
		while(true) {
			char c = getUserAction();
			if(c == 'n' && index < 9) {
				displayItem(++index);
			} else if(c == 'n' && index == 9) {
				break;
			} 
			if(c == 'p' && index > 0) {
				displayItem(--index);
			} 
			
		}
	}


}
