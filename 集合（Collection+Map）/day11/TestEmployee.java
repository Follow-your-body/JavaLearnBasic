/*
 * 集合中使用泛型的应用
	 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
	分别按以下两种方式对集合中的元素进行排序，并遍历输出：
		1). 使Employee 实现 Comparable 接口，并按 name 排序
		2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
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
		
		// 集合中使用泛型的应用
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
		System.out.println("按生日日期来排序，月，日，Comparator中重写compare方法，equals和hashCode必须重写");
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
		System.out.println("按姓名来排序自然排序，comparable中的compareTo方法，需要重写equals（）");
		for(Object obj : set1) {
			System.out.println(obj);
		}		
	}

}
