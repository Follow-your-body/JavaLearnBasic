package Exam5;

public class Exam {
	
	/**
	 * ��Exam���main�����е����ظ���ѭ��������getUserAction��������ӡ����ֵ��ֱ������ctrl-c��ʱ��������
	 * ֱ������ctrl-c��ʱ��������????
	 * */
	public static void main(String[] args) {
		ExamView ev = new ExamView();
		while(true) {
			System.out.println(ev.getUserAction());
		}
	}
	
}
