package Exam4;

public class Exam {
	/**
	 * 在Exam类的main方法中调用 saveAnswer方法，测试是否正常工作。
	 * */
	public static void main(String[] args) {
		ItemService is = new ItemService();
		char[] answer = {'A', 'B', 'C', 'D'};
		is.saveAnswer(answer);
	}
}
