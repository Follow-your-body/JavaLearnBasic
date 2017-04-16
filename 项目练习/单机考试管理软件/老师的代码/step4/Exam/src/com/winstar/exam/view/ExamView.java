package com.winstar.exam.view;

import java.util.Scanner;

import com.winstar.exam.service.ItemService;

public class ExamView {
	ItemService service = new ItemService();
	char[] answer = new char[service.getTotal()];

	// 需要判断输入的值是不是 A,B,C,D,N,P,
	// 如果是，返回输入的字符
	// 如果不是就让用户重新输入
	public char getUserAction() {
		Scanner scan = new Scanner(System.in);
		char[] keys = { 'A', 'B', 'C', 'D', 'N', 'P', 'F', 'Y', '1', '2', '3' };
		char ch = '\u0000';
		while (scan.hasNext()) {
			String str = scan.next();
			ch = str.toUpperCase().charAt(0);
			for (char key : keys) {
				if (ch == key) {
					return ch;// 返回的是大写的字符
				}
			}
			System.out.println("请重新输入");
		}
		return ch;
	}

	/*
	 * 显示每一道考題
	 */
	public void displayItem(int no) {

		System.out.println(service.getItem(no));
		if (answer[no - 1] != '\u0000') {
			System.out.println(answer[no - 1]);
		}
	}

	/*
	 * 
	 */
	public void testExam() {
		// 1.显示第一题，选择n显示下一题选择p显示上一题
		// 2.选择abcd的执行代码
		int itemNo = 1;
		displayWelcome();
		while (true) {

			displayItem(itemNo);
			char key = getUserAction();
			switch (key) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
				answer[itemNo - 1] = key;
			case 'N':// 显示下一题
				if (itemNo >= service.getTotal()) {
					service.saveAnswer(answer);
					showAnswers(answer);
					System.out.println("答题结束！！！");
					return;
				}
				itemNo++;
				break;
			case 'P':// 显示上一题
				if (itemNo <= 1) {
					System.out.println("当前已经是第一题");
				} else {
					itemNo--;
				}
				break;
			case 'F':
				// 判断一下是否要结束，如果确认结束
				if (isYN()) {
					// 保存答案
					service.saveAnswer(answer);
					// 判分，显示正确答案及分数
					showAnswers(answer);
					return;
				}
				break;

			}
		}

	}

	private void showAnswers(char[] answer) {
		System.out.println("序号\t正确答案\t用户选择");
		int score = 0;
		for (int i = 0; i < answer.length; i++) {
			char rightAnswer = service.getItem(i + 1).getAnswer().charAt(0);
			if (rightAnswer == answer[i]) {
				score += 100 / answer.length;
			}
			System.out.println("第" + (i + 1) + "题\t" + rightAnswer + "\t"
					+ answer[i]);
		}
		System.out.println("最后得分：" + score);
	}

	private boolean isYN() {
		System.out.println("您确定要结束吗，如果确定请输入y，否则输入n");
		while (true) {
			char key = getUserAction();
			if (key != 'Y' && key != 'N') {
				continue;
			}
			boolean b = (key == 'Y');
			return (b);

		}
	}

	private void displayWelcome() {
		System.out.println();
		System.out.println();
		System.out.println("----------欢迎进入考试----------");
		System.out.println();
		System.out.println("   使用以下按键进行考试:");
		System.out.println();
		System.out.println("        A-D:选择指定答案");
		System.out.println("        P:显示上一题");
		System.out.println("        N:显示下一题");
		System.out.println("        F：结束考试");
		System.out.println("         请按n键进入考试");
		while (true) {
			char key = getUserAction();
			if (key == 'N') {
				break;
			} else {
				System.out.println("您的输入不合法，请输入n/N");
			}
		}

	}

	private void displayMainMenu() {
		System.out.println();
		System.out.println();
		System.out.println("-------欢迎使用在线考试系统-------");
		System.out.println();
		System.out.println("       1 进入考试");
		System.out.println("       2 查看成绩");
		System.out.println("       3 系统退出");
		System.out.println();
		System.out.print("       请选择...");
	}

	public void mainMenu() {
		while (true) {
			displayMainMenu();
			char key = getUserAction();
			switch (key) {
			case '1':// 进入考试
				testExam();
				break;
			case '2':
				answer = service.readAnswer();
				showAnswers(answer);
				break;
			case '3':
				if(isYN()){
					return;
				}
				break;
			}
		}
	}

}
