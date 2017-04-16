/*
	Collection接口
		add(E e)+remove(Object o)+isEmpty()+iterator()+size()
		练习：RestCollection.java
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
		// add（） 添加元素（类型 不限）
		coll.add(123);
		coll.add("ASDV");
		coll.add(new String("asdfg"));
		// size() 计算长度
		System.out.println(coll.size());		
		coll.clear();  // 清空Collection
		System.out.println(coll.isEmpty());  // 判断Collection是否为空
		System.out.println(coll.size());
		// addAll(Collection c):添加多有的元素
		Collection coll1 = Arrays.asList(1, 2, 3);
		coll.addAll(coll1);
		System.out.println(coll.size());
	}
	
	@Test
	public void testCollection2() {
		Collection coll = new ArrayList();
		// add（） 添加元素（类型 不限）
		coll.add(123);
		coll.add("ASDV");
		coll.add(new String("asdfg"));
		// contains() 判断里面是否含有该元素
		System.out.println(coll.contains("ashnf"));	
		// containsAll(Collection c) 判断里面是否含有所有的该元素
		Collection coll1 = Arrays.asList("ASDV", "asdfg");
		System.out.println(coll.containsAll(coll1));	
	}

}
