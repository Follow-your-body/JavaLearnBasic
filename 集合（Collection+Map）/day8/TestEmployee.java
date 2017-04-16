package day8;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestEmployee {
	
	 public void testEmployee1() {
		 System.out.println("自然排序……");
		 
		 Set set = new TreeSet();
		set.add(new Employee("AA", 12, new MyDate(4, 1, 2017)));
		set.add(new Employee("CC", 14, new MyDate(7, 1, 2017)));
		set.add(new Employee("BB", 65, new MyDate(5, 1, 2017)));
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	 }
	 
	 public void testEmployee2() {
		 System.out.println("定制排序（时间，）……");
		 
		 Comparator com = new Comparator() {
			 
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Employee1 && o2 instanceof Employee1){
					Employee1 e1 = (Employee1)o1;
					Employee1 e2 = (Employee1)o2;
					MyDate birth1 = e1.getBrithday();
					MyDate birth2 = e2.getBrithday();
					if(birth1.getYear() != birth2.getYear()){
						return birth1.getYear() - birth2.getYear();
					}else{
						if(birth1.getMonth() != birth2.getMonth()){
							return birth1.getMonth() - birth2.getMonth();
						}else{
							return birth1.getDay() - birth2.getDay();
						}
					}
				}
				return 0;
			}
			
			};

		TreeSet set = new TreeSet(com);
		set.add(new Employee1("AA", 12, new MyDate(4, 1, 2020)));
		set.add(new Employee1("CC", 14, new MyDate(4, 2, 2018)));
		set.add(new Employee1("BB", 11, new MyDate(7, 1, 2024)));
		
		Iterator i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		// 集合可以用增强型for循环遍历，但是set是无序的，所以不能遍历
//		for(Object s1 : set) {
//			System.out.println(set);
//		}		
	}
	 

	public static void main(String[] args) {
		TestEmployee te = new TestEmployee();
		te.testEmployee1();
		te.testEmployee2();
		

	}

}
