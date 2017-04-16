package Exam6;

public class Item {
	
	private String subject;
	private String optionA;
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
