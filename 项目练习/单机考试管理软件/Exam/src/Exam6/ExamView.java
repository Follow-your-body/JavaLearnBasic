package Exam6;

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

	
	/**
	 * 该方法显示参数no指定的考题内容。
	 * @param no:int
	 * */
	public void displayItem(int no) {
		ItemService is = new ItemService();
		System.out.println(is.getItem(no));
	}
	
	
	/**
	 * 初始时，调用 displayItem显示考题第1题；
		调用 getUserAction方法，判断当用户键入n时，显示下一题；当用户键入p时，显示上一题（如果当前不是第1题时）；
		在当前为最后一题时键入n，方法结束并返回。

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
