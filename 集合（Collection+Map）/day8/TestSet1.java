/*
 	Collection子接口之一：Set接口
 		HashSet
		LinkedHashSet
		TreeSet（自然排序）
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
	 特点
				>无序性：真正的无序性，！=随机型，值得是元素在底层存储的位置是无序的
				>不可重复性：当Set中添加进相同的元素的时候，后面的这个不能添加进去
					说明：要求添加进Set中的元素所在的类，一定要重写equals()和HashCode（）方法
						进而保证Set中元素的不可重复性
				>存储方式：使用哈希算法，哈希数值相同的值不可重复加入
					当向Set中添加对象时，首先调用此对象所在类的HashCode（）方法，计算此时对象的哈希值，
					此哈希值决定了对象在Set中的存储位置，若此位置之前没有对象存储，则这个对象直接存储到此位置，
					若此位置已有对象存储，再通过equals（）比较这两个对象是否相同。
					如果相同，后一个对象就不能添加进来，反之两个对象都做到同一个位置（不建议这样）
					要求：HashCode方法和equal方法一致。
	 */
	@Test
	public void testHashSet() {
		System.out.println("此处输出HashSet类的用法…………");
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add(null);
		String str1 = "12";  // 引用数据类型字符串，数值相同（地址相同）
		String str2 = "12";		
		set.add(str1);
		set.add(str2);
		Person a1 = new Person();  // 引用数据类型，对象（地址不同）--插入两个，但是Set对象有可能属性都相同
		Person a2 = new Person();		// 所以需要重写equals（）来判断是不是有属性相同+地址不同的情况
		set.add(a1);
		set.add(a2);
				
		System.out.print(set.size() + "\t");
		System.out.println(set);		
	}
	
	/*
	 >维护了一个添加进集合的顺序，导致当我们遍历LinkedHashSet集合元素时，是按照添加进去的顺序遍历
					方法和HashSet类中的方法相同
				>是HashSet的子类
				>根据元素的hashcode值来决定元素的存储位置，但是它同时使用链表维护元素的次序
				 ，这使得元素看起来是以插入顺序保存的
				>插入性能略低于HashSet，但是迭代访问Set里的全部元素时有很好的性能
				>不允许集合元素重复
	 */
	@Test
	public void testLinkedHashSet() {
		System.out.println("此处输出LinkedHashSet类的用法…………");
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
	 排序方式
		<1>自然排序
			向TreeSet中添加元素时，首先按照conpareTo（）进行比较，一旦返回0，虽然仅是两个对象的此属性形同
			  ，但是程序会认为这两个对象是相同的，进而后一个对象不能添加进来
				set.add(new A("13", 14));		
				set.add(new A("11", 14));	
			因此要求conpareTo与hashCode+equals三者保持一致(conpareTo中对所有的属性都要有排序优先级)
	 */ 
	public void testTreeSet() {
		System.out.println("此处输出Comparable接口（自然排序）…………");
		Set set = new TreeSet();
		// 向TreeSet中添加的元素必须是同一个类型
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
			// 可以按照添加进集合的元素指定的顺序遍历(默认按照从小到大的顺序遍历)
			System.out.println(str.toString());
		}		
	}
	
	/*定制排序（Comparator接口，子类中的compare重写）	
	 * 1,创建一个实现了Comparator接口的类对象（匿名/不匿名），其中重写compare方法
	 * 2,将此对象作为形参传递给TreeSet的构造器
	 * 3,向TreeSet添加Comparator中的compare方法中设计的类的对象
	 * 	>hashCode和equals,compare必须一致，也就是说重写compare时要将所有的属性优先级排序
	 * */
	public void testTreeSet2() {
		System.out.println("此处输出Comparator接口（定制排序）…………");
		
		// 1,创建一个实现了Comparator接口的类对象（匿名）
		Comparator com = new Comparator() {
			/*
			  向TreeSet中添加Customer类的对象
			  ，在此Compare（）方法中，指明是按照Customer的哪个属性排序
			  id从小打到大排序，id相同时按name排序
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
		// 2,将此对象作为形参传递给TreeSet的构造器
		TreeSet set = new TreeSet(com);
		// 3,向TreeSet添加Comparator中的compare方法中设计的类的对象
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