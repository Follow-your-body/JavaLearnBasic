/*
	Collection�ӿ�
		add(E e)+remove(Object o)+isEmpty()+iterator()+size()
		��ϰ��RestCollection.java
*/
package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class RestCollection {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		RestCollection rc  = new RestCollection();
		rc.testCollection2();		
	}
	
	public void testCollection1() {
		Collection coll = new ArrayList();
		// add���� ���Ԫ�أ����� ���ޣ�
		coll.add(123);
		coll.add("ASDV");
		coll.add(new String("asdfg"));
		// size() ���㳤��
		System.out.println(coll.size());		
		coll.clear();  // ���Collection
		System.out.println(coll.isEmpty());  // �ж�Collection�Ƿ�Ϊ��
		System.out.println(coll.size());
		// addAll(Collection c):��Ӷ��е�Ԫ��
		Collection coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size());
	}
	
	@Test
	public void testCollection2() {
		Collection coll = new ArrayList();
		// add���� ���Ԫ�أ����� ���ޣ�
		coll.add(123);
		coll.add("ASDV");
		coll.add(new String("asdfg"));
		// contains() �ж������Ƿ��и�Ԫ��
		System.out.println(coll.contains("ashnf"));	
		// containsAll(Collection c) �ж������Ƿ������еĸ�Ԫ��
		Collection coll1 = Arrays.asList("ASDV", "asdfg");
		System.out.println(coll.containsAll(coll1));	
	}

}
