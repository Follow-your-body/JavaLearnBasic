package day11;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAnnotation {
	
	@Test   // JDK���ṩ�ĳ���ע��
	public void testAnnotation1() {
		Student s = new Student("danaay", 23);
		System.out.println(s.age);
		
		 // @Deprecated �����߳���Ա�����༴������ʹ��
		Person p = new Person();
		p.walk();
		
		@SuppressWarnings("unused")  // ���뾯�棨�ü��ϱ���δʹ�ã�
		List list = new ArrayList();		
	}
	
	@MyAnnotation(values = "�Զ���ע��")  // �Զ���ע��
	public void testAnnotation2() {
		
	}
}

class Person {
	String name;
	int age;
	
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Deprecated  // ���߳���Ա�����༴������ʹ��
	public void walk() {
		System.out.println("��·");
	}
	public void eat() {
		System.out.println("�Է�");
	}
}

class Student extends Person {
	public Student(String name, int age) {
		super(name, age);
	}
	@Override   // ��ʾ��д
	public void walk() {
		System.out.println("ѧ����·");
	}
	@Override   // ��ʾ��д
	public void eat() {
		System.out.println("ѧ���Է�");
	}
}