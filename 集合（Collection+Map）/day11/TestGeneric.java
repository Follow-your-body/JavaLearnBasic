package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {
	
	@Test
	public void testgeneric1() {
		List list = new ArrayList();
		// 1,没有使用泛型，任何的Object类型的对象都可以添加建立
		list.add(122);
		list.add(12);
		list.add(23);
		list.add("22");
		// 强转成Iteger类型时，会出现ClassCastException异常
		for(Object obj : list) {
			System.out.println((Integer)obj);
		}
	}
	
	@Test
	public void testgeneric2() {
		// 在集合中使用类型(只能是数据类型不能是基本数据类型)
		List<Integer> list = new ArrayList<Integer>();
		list.add(122);
		list.add(12);
		list.add(23);
		// 此处没有添加泛型符合的类型，编译就会报错
		// The method add(Integer) in the type List<Integer> is not applicable for the arguments (String)
//		list.add("22");
		// 遍历的时候不用类型的强制转换，类型编程了定义的数据类型（此处为Integer）
		for(Integer obj : list) {
			System.out.println(obj);
		}
		
		// map举例
		Map<String, Integer> map = new HashMap<>();
		map.put("danay", 12);
		map.put("anna", 11);
		map.put("sillive", 10);
		System.out.println(map);
		
		// 将Map对按Set来存(类型为Map.Entry<String, Integer>)
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> obj : set) {
			System.out.println(obj.getValue());
		}
		
	}
	
	@Test
	public void testgeneric3() {
		// 普通数据类型子类中的变量数值是可以赋值给父类的变量
		Object obj = null;
		String str = "ASD";
		obj = str;
		System.out.println(obj);
		
		// 泛型和继承的关系（泛型中的数据类型是不可以有这样的类型）	
		List<Object> list1 = new ArrayList<>();
		list1.add(123);
		List<String> list11 = new ArrayList<>();
		list11.add("AA");
		// 类A如果是类B的子集，那么类list<A>不是list<B>的子集
		// Type mismatch: cannot convert from List<String> to List<Object>
//		list1 = list11;		
		

	public void testgeneric4(){
		// list<A>和list<B>都是list<?>的子类
		List<?> list = null;
		List<Object> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		list = list2;
		list = list1;
		
		// ？extends A:可以存放A及其子类(<=)
		List<? extends Number> list4 = null;
		// 此处为<=之前类才可以，Object >= Number >= Integer
//		list4 = list1;   // 这个范围大于Number
		list4 = list3;		
		
		// ？super A:可以存放A及其父类（>=）
		List<? super Number> list5 = null;
		// 此处为>=之前类才可以，Object >= Number >= Integer
		list5 = list1;
//		list5 = list3;		// 这个范围小于Number
		
		// list通配符类型遍历
		Iterator<?> interator = list.iterator();
		while(interator.hasNext()) {
			System.out.println(interator.next());
		}		
		
	}
	
	@Test
	public void testOrder() {
		// 指定Order的泛型类为Boolean类型(该类的属性都可以用转换的类型调用)
		// 如果未定义类型，默认为Object类型
		Order<Boolean> order = new Order<Boolean>();
		order.setOrderId("11");
		// 定义泛型类中的泛型数据类型为Boolean数据类型
		order.setT(true);
		System.out.println(order.getT());
		
		// 先声明泛型类中的泛型数据类型，然后再用已经定义泛型数据类型的对象调用泛型函数
		Integer i = order.getE(23);
		Integer i1 = order.getE(34);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
