/*
�����ķ�ʽ
	forѭ��
		��������
	��ǿforѭ��
		��������+���϶���
	������
		���󣺼��϶���
	��ϰ TestIterator.java
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
				
		System.out.println("�����������������������û�е�����");
		Iterator iterator = coll.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
		
		System.out.println("��ǿforѭ���������ϱ���");
		for(Object i:coll) {
			System.out.println(i);
		}
		
		System.out.println("��ǿforѭ�������ַ����������");
		String[] str = new String[]{"DRTYF","GUBHINK"};
		for(String i:str) {
			System.out.println(i);
		}

		System.out.println("forѭ�������������");
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
