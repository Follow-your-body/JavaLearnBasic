package com.winstar.exam.test;

public class Teacher {
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", gender=" + gender + ", cls=" + cls
				+ "]";
	}

	private String name;
	private String gender;
	private String cls;

	public Teacher(String name, String gender, String cls) {
		super();
		this.name = name;
		this.gender = gender;
		this.cls = cls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

}
