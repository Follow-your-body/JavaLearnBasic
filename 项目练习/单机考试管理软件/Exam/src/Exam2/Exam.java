package Exam2;

import java.util.List;

public class Exam {
	/**
	 * 在Exam类的main方法中，创建ItemService对象并调用 readTextFile方法，来打印输出指定文本文件内容
	 * */
	public static void main(String[] args) {
		ItemService is = new ItemService();
		List list = is.readTextFile("E:\\Users\\danay\\workspace\\Exam\\Items.txt");
		System.out.print(list);
	}
}
