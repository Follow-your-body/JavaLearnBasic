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
	 *在方法中读取键盘键入值（每次只取键入序列的第一个键值），判断键值应为a、b、c、d、n、p、f键（包括大小写）值之一时，将其作为方法返回值，否则忽略不计
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
//				System.out.print("键入a、b、c、d中的任意键，将其记为当前题目的答案;键入n，进入下一题；键入p，进入上一题；键入f，结束考试。请输入：");
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
	 * 该方法显示参数no指定的考题内容。
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
	 * 调用 getUserAction方法，判断当用户键入a、b、c、d中的任意键时，将其记为当前题目的答案（记入answer数组中）；
	 * 在显示最后一题时键入n，方法结束， 调用ItemService中的saveAnswer保存所有答案，并返回。
	 * */
	public int testExam() {
		ItemService is = new ItemService();
		answer = new char[1024];
		int index = 0;
		int score = 0;
		
		System.out.println("帮助信息：当用户键入a、b、c、d中的任意键时，将其记为当前题目的答案，"
				+ "当用户键入n时，进入下一题；当用户键入p时，进入上一题；在显示最后一题时键入n退出考试！\n");
		
		displayItem(index);
		while(true) {
			System.out.println("您填写的答案为：" + answer[index]);
			System.out.print("键入a、b、c、d中的任意键，将其记为当前题目的答案;键入n，进入下一题；键入p，进入上一题；键入f，结束考试。请输入：");
			char c = getUserAction();
			// 答案
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
			// f为结束
			if(c == 'f') {
				System.out.print("是否结束答题，如果确定请键入Y，否则键入N，请输入：");
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
						System.out.println(i + ". 正确答案为： " + (char)rightAnswer[0] + "\t你的答案是：" + answer[i]);
					}
					System.out.println("你的成绩为：" + score);
					break;
				}
			}
		}
		return score;
	}


}
