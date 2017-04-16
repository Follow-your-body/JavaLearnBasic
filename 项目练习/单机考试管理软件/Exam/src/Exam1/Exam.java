package Exam1;

public class Exam {
	/**
	 * 在Exam类的main方法中，创建ItemService对象并调用 readTextFile方法，来打印输出指定文本文件内容
	 * */
	public static void main(String[] args) {
		ItemService is = new ItemService();
		is.readTextFile("E:\\Users\\danay\\workspace\\Exam\\Items.txt");
	}
}
