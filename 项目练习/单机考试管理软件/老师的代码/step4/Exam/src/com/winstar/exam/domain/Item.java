package com.winstar.exam.domain;


public class Item {
	// 题干
	private String question;
	// 四个选项
	private String[] option;
	// 答案
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
