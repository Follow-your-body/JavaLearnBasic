/*
 * ������ʹ�÷��͵�Ӧ��
	 ��������� 5 �����󣬲�����Щ������� TreeSet �����У���һ�£�TreeSet ��ʹ�÷��������壩
	�ֱ��������ַ�ʽ�Լ����е�Ԫ�ؽ������򣬲����������
		1). ʹEmployee ʵ�� Comparable �ӿڣ����� name ����
		2). ���� TreeSet ʱ���� Comparator���󣬰��������ڵ��Ⱥ�����
 */
package day11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TestEmployee {

	public static void main(String[] arg0) {
				
		Comparator com = new Comparator() {

			@Override
			public int compare(Object obj1, Object obj2) {
				if(obj1 instanceof Employee1 && obj2 instanceof Employee1) {
					Employee1 e1 = (Employee1) obj1;
					Employee1 e2 = (Employee1) obj2;
					MyDate birth1 = e1.getBirthday();
					MyDate birth2 = e2.getBirthday();
					int i = birth1.getMonth().compareTo(birth2.getMonth());
					if(i == 0) {
						return birth1.getDay().compareTo(birth2.getDay());
					}else {
						return i;
					}
				}
				return 0;
			}
			
		};
		
		// ������ʹ�÷��͵�Ӧ��
		TreeSet<Employee1> set = new TreeSet<>(com);
		Employee1 e1 = new Employee1("AA", 12, new MyDate(4, 1, 2017));
		Employee1 e2 = new Employee1("CC", 12, new MyDate(4, 6, 2017));
		Employee1 e3 = new Employee1("DD", 12, new MyDate(4, 5, 2017));
		Employee1 e4 = new Employee1("BB", 12, new MyDate(4, 4, 2017));
		Employee1 e5 = new Employee1("EE", 12, new MyDate(5, 5, 2017));
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		set.add(e5);
		
		Iterator interator1 = set.iterator();
		System.out.println("�����������������£��գ�Comparator����дcompare������equals��hashCode������д");
		while(interator1.hasNext()) {
			System.out.println(interator1.next());
		}
		
		TreeSet<Employee> set1 = new TreeSet<>();
		Employee e11 = new Employee("AA", 12, new MyDate(4, 1, 2017));
		Employee e12 = new Employee("DD", 12, new MyDate(4, 1, 2017));
		Employee e13 = new Employee("SS", 12, new MyDate(4, 1, 2017));
		Employee e14 = new Employee("BB", 12, new MyDate(4, 1, 2017));
		Employee e15 = new Employee("EE", 12, new MyDate(4, 1, 2017));
		set1.add(e11);
		set1.add(e12);
		set1.add(e13);
		set1.add(e14);
		set1.add(e15);
		System.out.println("��������������Ȼ����comparable�е�compareTo��������Ҫ��дequals����");
		for(Object obj : set1) {
			System.out.println(obj);
		}		
	}

}
