package Exam4;

public class Exam {
	/**
	 * ��Exam���main�����е��� saveAnswer�����������Ƿ�����������
	 * */
	public static void main(String[] args) {
		ItemService is = new ItemService();
		char[] answer = {'A', 'B', 'C', 'D'};
		is.saveAnswer(answer);
	}
}
