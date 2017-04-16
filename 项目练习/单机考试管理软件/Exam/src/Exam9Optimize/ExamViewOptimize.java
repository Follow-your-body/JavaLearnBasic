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
	 * 在方法中读取键盘键入值（每次只取键入序列的第一个键值），判断键值应为a、b、c、d、n、p、f键（包括大小写）值之一时，将其作为方法返回值，否则忽略不计
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
				// System.out.print("键入a、b、c、d中的任意键，将其记为当前题目的答案;键入n，进入下一题；键入p，进入上一题；键入f，结束考试。请输入：");
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
	 * 该方法显示参数no指定的考题内容。
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
	 * 调用 getUserAction方法，判断当用户键入a、b、c、d中的任意键时，将其记为当前题目的答案（记入answer数组中）；
	 * 在显示最后一题时键入n，方法结束， 调用ItemService中的saveAnswer保存所有答案，并返回。
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
				System.out.println("上一次的成绩为：" + lastScore);
			}

			if (c == '1') {
				int index = 0;
				int score = 0;

				System.out.println("\n\n帮助信息：");
				System.out.println("  键入a、b、c、d中的任意键，将其记为当前题目的答案");
				System.out.println("  键入n，进入下一题");
				System.out.println("  键入p，进入上一题");
				System.out.println("  键入f，结束考试。\n");

				displayItem(index);
				while (true) {
					System.out.print("您填写的答案为：" + answer[index]);
					c = getUserAction();
					// 答案
					if ("ABCDabcd".indexOf(c) != -1) {
						answer[index] = c;
						System.out.print("键入n，进入下一题；键入p，进入上一题；键入f，结束考试。请输入：");
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
					// f为结束
					if (c == 'f') {
						System.out.print("是否结束答题，如果确定请键入Y，否则键入N，请输入：");
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
								System.out.println(i + ". 正确答案为： " + (char) rightAnswer[0] + "\t你的答案是：" + answer[i]);
							}
							System.out.println("你的成绩为：" + score);
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
		System.out.println("-------欢迎使用在线考试系统-------");
		System.out.println();
		System.out.println();
		System.out.println("	1.进入考试");
		System.out.println("	2.显示上次考试成绩");
		System.out.println("	3.退出考试系统化");
		System.out.print("	请根据主菜单中选择：");
		
		char key = ' ';
		while(true) {
			key = getUserAction();
			if("123".indexOf(key) != -1) {
				break;
			}
			System.out.print("输入不正确，请重新输入：");
		}
		return key;		
	}

}
