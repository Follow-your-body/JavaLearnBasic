/*
 *  ����һ��ManKind�࣬����
��Ա����int sex��int salary��
����void manOrWorman()������sex��ֵ��ʾ��man��(sex==1)���ߡ�woman��(sex==0)��
����void employeed()������salary��ֵ��ʾ��no job��(salary==0)���ߡ� job��(salary!=0)��
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
