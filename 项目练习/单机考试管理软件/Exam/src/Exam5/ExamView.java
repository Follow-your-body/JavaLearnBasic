package Exam5;

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

}
