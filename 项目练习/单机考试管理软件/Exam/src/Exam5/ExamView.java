package Exam5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.junit.Test;

public class ExamView {
	
	/**
	 *在方法中读取键盘键入值（每次只取键入序列的第一个键值），判断键值应为a、b、c、d、n、p键（包括大小写）值之一时，将其作为方法返回值，否则忽略不计
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
				System.out.print("请输入内容：");
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
