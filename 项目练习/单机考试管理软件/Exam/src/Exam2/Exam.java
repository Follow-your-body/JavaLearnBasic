package Exam2;

import java.util.List;

public class Exam {
	/**
	 * ��Exam���main�����У�����ItemService���󲢵��� readTextFile����������ӡ���ָ���ı��ļ�����
	 * */
	public static void main(String[] args) {
		ItemService is = new ItemService();
		List list = is.readTextFile("E:\\Users\\danay\\workspace\\Exam\\Items.txt");
		System.out.print(list);
	}
}
