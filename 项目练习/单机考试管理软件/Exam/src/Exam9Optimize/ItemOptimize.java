/**
 * ��Ŀ
 * ��������10��ѡ������ı��ļ���ѡ�������ݰ�����Ŀ��4��ѡ��ͱ�׼�𰸣���Ϊ��ѡ����
 * ������ĿItem�࣬������������ѡ���Ӧ�����ṩ��Ӧ��get/set������
 * 
 * ����
 * ��һ����Ŀ��Ϊһ�������˼·����ȷ�ģ���������ķ�ʽҲ����ȷ��
 * �Ż����ĸ�ѡ����������������ʽ��ͳһ����
 * 
 * �ɼ�
 * 9
 * */
package Exam9Optimize;

import java.util.Arrays;

public class ItemOptimize {
	
	private String subject;		// ��Ŀ
	private String option[];	// ѡ��
	private String answer;		// ��
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
