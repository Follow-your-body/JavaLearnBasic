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
	 * 调用 getUserAction方法，判断当用户键入a、b、c、d中的任意键时，将其记为当前题目的答案（记入answer数组中）；
	 * 在显示最后一题时键入n，方法结束， 调用ItemService中的saveAnswer保存所有答案，并返回。
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
