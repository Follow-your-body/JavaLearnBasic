package com.winstar.exam.view;

import java.util.Scanner;

import com.winstar.exam.service.ItemService;

public class ExamView {
	char[] answer = new char[10];// ????
	ItemService service = new ItemService();

	// 需要判断输入的值是不是 A,B,C,D,N,P,
	// 如果是，返回输入的字符
	// 如果不是就让用户重新输入
	// ??健壮性有问题，如果直接输入回车？？
	public char getUserAction() {
		Scanner scan = new Scanner(System.in);
		char[] keys = { 'A', 'B', 'C', 'D', 'N', 'P','F'};
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
		// 2.
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
				if (itemNo >= 10) {
					System.out.println("答题结束！！！");
					service.saveAnswer(answer);
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

			}
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
		while(true){
			char key=getUserAction();
			if(key=='N'){
				break;
			}else{
				System.out.println("您的输入不合法，请输入n/N");
			}
		}

	}

}
