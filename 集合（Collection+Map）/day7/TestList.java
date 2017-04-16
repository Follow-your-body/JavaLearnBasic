/*
 * 		Collection子接口之二：List接口（增+删+改+查+插+长度）
		ArrayList：List的主要实现类
			特点：元素有序+可重复-动态数组（顺序实现）
			新增加的方法
				void add(int index, Object ele)：增
				Object remove(int index)：删
				Object set(int index, Object ele)：改
				Object get(int index)：查
				boolean addAll(int index, Collection eles)：插			
				int indexOf(Object obj)：obj首次出现的位置
				int lastIndexOf(Object obj)：obj最后出现的位置			
				List subList(int fromIndex, int toIndex)：切片
			常用的方法
				增（add） 删(remove,索引/值) 改（set） 查（get） 插（add（int index， Object obj）长度（size）） 	
		LinkList
			特点：底层拿链表实现
			比较：对于频繁的插入和删除操作，比ArrayList所用时间较短
			方法：和ArrayList完全一样	
		Vector
			特点：古老的实现类+线程安全的+不用这个
		练习：TestList.java
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
		
		System.out.println("add添加");
		list.add("1");
		list.add(2);
		list.add(new String("3"));
		System.out.println(list);
		
		System.out.println("remove删除");
		list.remove("1");
		System.out.println(list);
		
		System.out.println("设置指定位置的元素变成一个新的数值");
		list.set(0, 2);
		System.out.println(list.get(0));
		
		System.out.println("获取指定位置的信息");
		System.out.println(list.get(1));	
		
		System.out.println("指定位置添加(本来在该位置的往后退一个位置)");
		list.add(2, "323");
		System.out.println(list);		
		System.out.println("…………即使是组合也算添加一个");
		Collection coll = new ArrayList();
		coll.add("4");
		coll.add(5);
		list.add(0, coll);
		System.out.println(list);			
		
		System.out.println("返回obj首次出现的位置，没有返回-1");		
		System.out.println(list.indexOf("123"));
		
		System.out.println("返回obj最后出现的位置，没有返回-1");
		System.out.println(list.indexOf(2));
		
		System.out.println("获取list中的一部分");
		List list2 = list.subList(1, 2);
		System.out.println(list2);
	}

	public static void main(String[] args) {
		TestList tl = new TestList();
		tl.testList();
		

	}

}
