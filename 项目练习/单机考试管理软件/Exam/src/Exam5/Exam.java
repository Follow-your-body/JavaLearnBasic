package Exam5;

public class Exam {
	
	/**
	 * 在Exam类的main方法中调用重复（循环）调用getUserAction方法，打印返回值，直到键入ctrl-c键时结束运行
	 * 直到键入ctrl-c键时结束运行????
	 * */
	public static void main(String[] args) {
		ExamView ev = new ExamView();
		while(true) {
			System.out.println(ev.getUserAction());
		}
	}
	
}
