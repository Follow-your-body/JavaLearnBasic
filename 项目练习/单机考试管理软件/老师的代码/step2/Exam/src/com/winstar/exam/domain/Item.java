package com.winstar.exam.domain;

import java.util.Arrays;

/*
 * *��1�� Java���������귢���ģ�
 *A. 1991
 *B. 1994
 *C. 1996
 *D. 1999
 *A
 */
public class Item {
	// ���
	private String question;
	// �ĸ�ѡ��
	private String[] option;
	// ��
	private String answer;

	public Item(String question, String[] option, String answer) {
		super();
		this.question = question;
		this.option = option;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
		return question + "\n" + option[0] + "\n" + option[1] + "\n"
				+ option[2] + "\n" + option[3] + "\n";
	}
}
