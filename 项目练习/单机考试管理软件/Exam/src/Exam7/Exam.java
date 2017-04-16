package Exam7;

public class Exam {

	/**
	 * 在Exam类的main方法中调用 ExamView类的testExam方法，测试题目显示及按键操作是否正确。
	 */
	public static void main(String[] args) {
		ExamView ev = new ExamView();
		System.out.println("输入的答案有：" + ev.testExam());
	}

}
