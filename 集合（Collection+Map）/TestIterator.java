/*
遍历的方式
	for循环
		对象：数组
	增强for循环
		对象：数组+集合对象
	迭代器
		对象：集合对象
	练习 TestIterator.java
*/
package day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(new String("SSS"));
		coll.add("BBB");
				
		System.out.println("迭代器——对象遍历（数组没有迭代器");
		Iterator iterator = coll.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
		
		System.out.println("增强for循环——集合遍历");
		for(Object i:coll) {
			System.out.println(i);
		}
		
		System.out.println("增强for循环——字符串数组遍历");
		String[] str = new String[]{"DRTYF","GUBHINK"};
		for(String i:str) {
			System.out.println(i);
		}

		System.out.println("for循环——数组遍历");
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestIterator ti = new TestIterator();
		ti.test1();
	}

}
