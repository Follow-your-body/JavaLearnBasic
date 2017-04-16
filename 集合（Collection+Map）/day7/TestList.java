/*
 * 		Collection�ӽӿ�֮����List�ӿڣ���+ɾ+��+��+��+���ȣ�
		ArrayList��List����Ҫʵ����
			�ص㣺Ԫ������+���ظ�-��̬���飨˳��ʵ�֣�
			�����ӵķ���
				void add(int index, Object ele)����
				Object remove(int index)��ɾ
				Object set(int index, Object ele)����
				Object get(int index)����
				boolean addAll(int index, Collection eles)����			
				int indexOf(Object obj)��obj�״γ��ֵ�λ��
				int lastIndexOf(Object obj)��obj�����ֵ�λ��			
				List subList(int fromIndex, int toIndex)����Ƭ
			���õķ���
				����add�� ɾ(remove,����/ֵ) �ģ�set�� �飨get�� �壨add��int index�� Object obj�����ȣ�size���� 	
		LinkList
			�ص㣺�ײ�������ʵ��
			�Ƚϣ�����Ƶ���Ĳ����ɾ����������ArrayList����ʱ��϶�
			��������ArrayList��ȫһ��	
		Vector
			�ص㣺���ϵ�ʵ����+�̰߳�ȫ��+�������
		��ϰ��TestList.java
* */
package day7;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class TestList {
	
	@Test
	public void testList() {
		List list = new ArrayList();
		
		System.out.println("add���");
		list.add("1");
		list.add(2);
		list.add(new String("3"));
		System.out.println(list);
		
		System.out.println("removeɾ��");
		list.remove("1");
		System.out.println(list);
		
		System.out.println("����ָ��λ�õ�Ԫ�ر��һ���µ���ֵ");
		list.set(0, 2);
		System.out.println(list.get(0));
		
		System.out.println("��ȡָ��λ�õ���Ϣ");
		System.out.println(list.get(1));	
		
		System.out.println("ָ��λ�����(�����ڸ�λ�õ�������һ��λ��)");
		list.add(2, "323");
		System.out.println(list);		
		System.out.println("����������ʹ�����Ҳ�����һ��");
		Collection coll = new ArrayList();
		coll.add("4");
		coll.add(5);
		list.add(0, coll);
		System.out.println(list);			
		
		System.out.println("����obj�״γ��ֵ�λ�ã�û�з���-1");		
		System.out.println(list.indexOf("123"));
		
		System.out.println("����obj�����ֵ�λ�ã�û�з���-1");
		System.out.println(list.indexOf(2));
		
		System.out.println("��ȡlist�е�һ����");
		List list2 = list.subList(1, 2);
		System.out.println(list2);
	}

	public static void main(String[] args) {
		TestList tl = new TestList();
		tl.testList();
		

	}

}
