/*
 	Collection�ӽӿ�֮һ��Set�ӿ�
 		HashSet
		LinkedHashSet
		TreeSet����Ȼ����
 */
package day8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet1 {
	
	/*
	 �ص�
				>�����ԣ������������ԣ���=����ͣ�ֵ����Ԫ���ڵײ�洢��λ���������
				>�����ظ��ԣ���Set����ӽ���ͬ��Ԫ�ص�ʱ�򣬺�������������ӽ�ȥ
					˵����Ҫ����ӽ�Set�е�Ԫ�����ڵ��࣬һ��Ҫ��дequals()��HashCode��������
						������֤Set��Ԫ�صĲ����ظ���
				>�洢��ʽ��ʹ�ù�ϣ�㷨����ϣ��ֵ��ͬ��ֵ�����ظ�����
					����Set����Ӷ���ʱ�����ȵ��ô˶����������HashCode���������������ʱ����Ĺ�ϣֵ��
					�˹�ϣֵ�����˶�����Set�еĴ洢λ�ã�����λ��֮ǰû�ж���洢�����������ֱ�Ӵ洢����λ�ã�
					����λ�����ж���洢����ͨ��equals�����Ƚ������������Ƿ���ͬ��
					�����ͬ����һ������Ͳ�����ӽ�������֮������������ͬһ��λ�ã�������������
					Ҫ��HashCode������equal����һ�¡�
	 */
	@Test
	public void testHashSet() {
		System.out.println("�˴����HashSet����÷���������");
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add(null);
		String str1 = "12";  // �������������ַ�������ֵ��ͬ����ַ��ͬ��
		String str2 = "12";		
		set.add(str1);
		set.add(str2);
		Person a1 = new Person();  // �����������ͣ����󣨵�ַ��ͬ��--��������������Set�����п������Զ���ͬ
		Person a2 = new Person();		// ������Ҫ��дequals�������ж��ǲ�����������ͬ+��ַ��ͬ�����
		set.add(a1);
		set.add(a2);
				
		System.out.print(set.size() + "\t");
		System.out.println(set);		
	}
	
	/*
	 >ά����һ����ӽ����ϵ�˳�򣬵��µ����Ǳ���LinkedHashSet����Ԫ��ʱ���ǰ�����ӽ�ȥ��˳�����
					������HashSet���еķ�����ͬ
				>��HashSet������
				>����Ԫ�ص�hashcodeֵ������Ԫ�صĴ洢λ�ã�������ͬʱʹ������ά��Ԫ�صĴ���
				 ����ʹ��Ԫ�ؿ��������Բ���˳�򱣴��
				>���������Ե���HashSet�����ǵ�������Set���ȫ��Ԫ��ʱ�кܺõ�����
				>��������Ԫ���ظ�
	 */
	@Test
	public void testLinkedHashSet() {
		System.out.println("�˴����LinkedHashSet����÷���������");
		Set set = new LinkedHashSet();
		set.add(123);
		set.add("aa");
		set.add(new String("BB"));
		set.add(null);
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/*
	 ����ʽ
		<1>��Ȼ����
			��TreeSet�����Ԫ��ʱ�����Ȱ���conpareTo�������бȽϣ�һ������0����Ȼ������������Ĵ�������ͬ
			  �����ǳ������Ϊ��������������ͬ�ģ�������һ����������ӽ���
				set.add(new A("13", 14));		
				set.add(new A("11", 14));	
			���Ҫ��conpareTo��hashCode+equals���߱���һ��(conpareTo�ж����е����Զ�Ҫ���������ȼ�)
	 */ 
	public void testTreeSet() {
		System.out.println("�˴����Comparable�ӿڣ���Ȼ���򣩡�������");
		Set set = new TreeSet();
		// ��TreeSet����ӵ�Ԫ�ر�����ͬһ������
//		set.add(123);
//		set.add(null);
//		set.add("AA");
//		set.add("aa");
//		set.add("aa");
//		set.add(new String("BB"));
//		set.add(new String("BB"));		

		set.add(new Person("12", 11));
		set.add(new Person("12", 12));		
		set.add(new Person("42", 13));		
		set.add(new Person("13", 14));		
		set.add(new Person("11", 14));		
		
		for(Object str : set) {
			// ���԰�����ӽ����ϵ�Ԫ��ָ����˳�����(Ĭ�ϰ��մ�С�����˳�����)
			System.out.println(str.toString());
		}		
	}
	
	/*��������Comparator�ӿڣ������е�compare��д��	
	 * 1,����һ��ʵ����Comparator�ӿڵ����������/����������������дcompare����
	 * 2,���˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�����
	 * 3,��TreeSet���Comparator�е�compare��������Ƶ���Ķ���
	 * 	>hashCode��equals,compare����һ�£�Ҳ����˵��дcompareʱҪ�����е��������ȼ�����
	 * */
	public void testTreeSet2() {
		System.out.println("�˴����Comparator�ӿڣ��������򣩡�������");
		
		// 1,����һ��ʵ����Comparator�ӿڵ������������
		Comparator com = new Comparator() {
			/*
			  ��TreeSet�����Customer��Ķ���
			  ���ڴ�Compare���������У�ָ���ǰ���Customer���ĸ���������
			  id��С�򵽴�����id��ͬʱ��name����
			 */ 
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer) {
					Customer c1 = (Customer)o1;
					Customer c2 = (Customer)o2;
					int i = c1.getId().compareTo(c2.getId());
					if (i == 0) {
						return c1.getName().compareTo(c2.getName());
					} else {
						return i;
					}
				}
				return 0;
			}
		};
		// 2,���˶�����Ϊ�βδ��ݸ�TreeSet�Ĺ�����
		TreeSet set = new TreeSet(com);
		// 3,��TreeSet���Comparator�е�compare��������Ƶ���Ķ���
		set.add(new Customer("ZZ", 1292));
		set.add(new Customer("BB", 1224));
		set.add(new Customer("EE", 1224));
		set.add(new Customer("DD", 1225));
		set.add(new Customer("CC", 1226));
		set.add(new Customer("JJ", 1227));
		
		for(Object str : set) {
			System.out.println(str);
		}
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSet1 ts = new TestSet1();
		ts.testHashSet();
		ts.testLinkedHashSet();
		ts.testTreeSet();
		ts.testTreeSet2();
	}

}