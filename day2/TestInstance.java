/*
��̬��ʹ�ð���
*/
package com.lzw;

public class TestInstance {
	
	public void method1(Person2 e) {
		if(e instanceof Student2) {  // �жϸ�ʵ�����ĸ����
			System.out.print("a student!\t");
		}else if(e instanceof Person2) {
			System.out.print("a person!\t");
		}else {
			System.out.print("a graduated student!\t");
		}
		System.out.println(e.getInfo());
	}

	public static void main(String[] args) {
		TestInstance ti = new TestInstance();
		// ��̬��ʹ�÷�ʽ
		ti.method1(new Person2());   // Person2ʵ��������ΪPerson2�Ķ���
		ti.method1(new Student2()); // Student2ʵ��������ΪPerson2�Ķ���
		ti.method1(new Graduate()); // Graduateʵ��������ΪPerson2�Ķ���

	}

}