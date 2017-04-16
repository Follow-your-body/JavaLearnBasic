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
package Exam9Optimize;

import java.util.Arrays;

public class ItemOptimize {
	
	private String subject;		// 题目
	private String option[];	// 选项
	private String answer;		// 答案
	public ItemOptimize(String subject, String[] option, String answer) {
		super();
		this.subject = subject;
		this.option = option;
		this.answer = answer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String[] getOption() {
		return option;
	}
	public void setOption(String[] option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "ItemOptimize [subject=" + subject + ", option=" + Arrays.toString(option) + ", answer=" + answer + "]";
	}
	
}
