/**
 * 题目
 * 制作包含10道选择题的文本文件，选择题内容包括题目、4个选项和标准答案（均为单选）；
 * 定义题目Item类，属性与上述单选题对应，并提供对应的get/set方法；
 * 
 * 评论
 * 将一个题目作为一个对象的思路是正确的，创建对象的方式也是正确的
 * 优化：四个选项可以做成数组的形式，统一操作
 * 
 * 成绩
 * 9
 * */
package Exam9;

public class Item {
	
	private String subject;
	private String optionA;     // TODO 选项做成多个比较好
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	public Item(String subject, String optionA, String optionB, String optionC, String optionD, String answer) {
		super();
		this.subject = subject;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Item [subject=" + subject + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + "]";
	}
	
}
