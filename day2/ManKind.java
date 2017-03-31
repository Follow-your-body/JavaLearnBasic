/*
 *  定义一个ManKind类，包括
成员变量int sex和int salary；
方法void manOrWorman()：根据sex的值显示“man”(sex==1)或者“woman”(sex==0)；
方法void employeed()：根据salary的值显示“no job”(salary==0)或者“ job”(salary!=0)。
*/
package com.lzw;

public class ManKind {
	private int sex;
	public int salary;
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getSex() {
		return sex;
	}
	
	public void manOrWoman(int sex) {
		if(sex == 1){
			System.out.println("man");
		}else {
			System.out.println("woman");
		}
	}
	
	public void employeed(int salary) {
		if(salary != 0) {
			System.out.println("job");
		}else {
			System.out.println("no job");
		}
	}

}
