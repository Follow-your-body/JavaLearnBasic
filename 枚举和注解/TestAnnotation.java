package day11;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAnnotation {
	
	@Test   // JDK中提供的常用注解
	public void testAnnotation1() {
		Student s = new Student("danaay", 23);
		System.out.println(s.age);
		
		 // @Deprecated ：告诉程序员，该类即将不被使用
		Person p = new Person();
		p.walk();
		
		@SuppressWarnings("unused")  // 编译警告（该集合变量未使用）
		List list = new ArrayList();		
	}
	
	@MyAnnotation(values = "自定义注解")  // 自定义注解
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
	@Deprecated  // 告诉程序员，该类即将不被使用
	public void walk() {
		System.out.println("走路");
	}
	public void eat() {
		System.out.println("吃饭");
	}
}

class Student extends Person {
	public Student(String name, int age) {
		super(name, age);
	}
	@Override   // 表示重写
	public void walk() {
		System.out.println("学生走路");
	}
	@Override   // 表示重写
	public void eat() {
		System.out.println("学生吃饭");
	}
}