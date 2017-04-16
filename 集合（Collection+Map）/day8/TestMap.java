/*
 * 
 * */
package day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TestMap {
	/*
	 添加、删除操作
			Object put(OBject key, Object value)
			Object remove(Object key)
			void putAll(Map t)
			void clear()
	元视图操作的方法
			Set keySet()：key使用set来存放的，不可重复
			Collection values()：value是用Colltion来存放的，可重复	
			Set entrySet()：key-value对，是一个entry，所有的entry使用Set存放，也不可重复
	元素查询的操作
			Object get（Object key）
			boolean containsKey(Object key)
			boolean containsValue(Object value)
			int size()
			boolean isEmpty()
			boolean equals(Object obj) 
						
	HashMap:key使用set来存放的，不可重复;
			value是用Colltion来存放的，可重复			
			key-value对，是一个entry，所有的entry使用Set存放，也不可重复
			key和value都可以为null			
			向HashMap中添加元素时，会调用Key所在类的equals方法，判断两个key是否相同，若相同进后面的
			HashCode和equals方法要重写
			LinkedHashMap和HashMap相同，只是存储的时候不同而已
	TreeMap：按照key中一定的属性进行排序
	
	 */
	@Test
	public void testHashMap1() {
		System.out.println("添加对象………………");
		Map map = new HashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value对，是一个entry，所有的entry使用Set存放，也不可重复
		map.put("AA", 2013);	// key使用set来存放的，不可重复;
		map.put("CC", 2014);
		map.put("BB", 2013);
		map.put("DD", 2015);
		map.put("EE", null);	// key和value都可以为null
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		System.out.println("删除对象………………");
		map.remove(null);
		System.out.println(map);
		
		System.out.println("清空对象………………");
		map.clear();
		System.out.println(map);		
	}
	
	public void testHashMap2() {
		System.out.println("添加对象……按输入顺序输入…………");
		Map map = new HashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value对，是一个entry，所有的entry使用Set存放，也不可重复
		map.put("AA", 2013);	// key使用set来存放的，不可重复;
		map.put("CC", 2014);
		map.put("BB", 2013);
		map.put("EE", null);	// key和value都可以为null
		map.put("DD", 2015);
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		System.out.println("遍历key集……");  // key是按Set集合存储
		Set set = map.keySet();
		for(Object obj : set) {
			System.out.println(obj);			
		}
		
		System.out.println("遍历value集……"); // value是按collection集合存储
		Collection values = map.values();
		for(Object obj : values) {
			System.out.println(obj);			
		}
		
		System.out.println("遍历key-value对，方式一……"); // value是按collection集合存储
		Set set1 = map.keySet();
		for(Object obj : set1) {
			System.out.println(obj +"-->" + map.get(obj));			
		}
		
		System.out.println("遍历key-value对,方式二……"); // value是按collection集合存储
		Set set2 = map.entrySet();
		for(Object obj : set2) {
			System.out.println(obj);			
		}
	}
	
	@Test
	public void testLinkedHashMap() {
		System.out.println("添加对象………按输入排序………");
		Map map = new LinkedHashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value对，是一个entry，所有的entry使用Set存放，也不可重复
		map.put("AA", 2013);	// key使用set来存放的，不可重复;
		map.put("DD", 2015);
		map.put("BB", 2013);
		map.put("CC", 2014);
		map.put("EE", null);	// key和value都可以为null
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		// 使用链表添加进Map中的顺序，故遍历Map时，时按照添加的顺序
		System.out.println("遍历key集……");  // key是按Set集合存储
		Set set = map.keySet();
		for(Object obj : set) {
			System.out.println(obj);			
		}
	}
		
	public void TestTreeMap1() {
		System.out.println("<TestTreeMap类测试>");
		System.out.println("添加对象………排列顺序自动改变（先姓名后年龄）………");
		TreeMap map = new TreeMap();		
		map.put(new Person("AA", 32), 2013);
		map.put(new Person("BB", 33), 2014);
		map.put(new Person("AA", 34), 2014);
		map.put(new Person("EE", 35), 2014);
		map.put(new Person("DD", 32), 2014);
		map.put(new Person("FF", 32), 2014);
		System.out.println(map);
	}
	
	public void TestTreeMap2() {
		System.out.println("<TestTreeMap类测试>");
		System.out.println("添加对象………自定义key属性排序（先年龄后姓名）………");
		// 先按年龄然后按姓名排序
		Comparator com = new Comparator(){
			@Override
			public int compare(Object obj1, Object obj2) {
				if(obj1 instanceof Person1 && obj2 instanceof Person1){
					Person1 p1 = (Person1) obj1;
					Person1 p2 = (Person1) obj2;
					int i = p1.getAge().compareTo(p2.getAge());
					if(i == 0) {
						return p1.getName().compareTo(p2.getName());
					}else {
						return i;
					}					
				}
				return 0;
			}			
		};
		
		TreeMap map = new TreeMap(com);		
		map.put(new Person1("AA", 30), 2013);
		map.put(new Person1("BB", 30), 2014);
		map.put(new Person1("AA", 34), 2014);
		map.put(new Person1("EE", 32), 2014);
		map.put(new Person1("DD", 33), 2014);
		map.put(new Person1("FF", 36), 2014);
		System.out.println(map);
	}
	
	@Test
	public void testHashTable() throws FileNotFoundException, IOException{
		// 使用Properties属性处理留文件类型
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdbc.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String password = pros.getProperty("password");
		System.out.println(password);
	}
	
	
	@Test
	public void testMusic () {
		System.out.println(4 ^ 4);  // ^为异或
		System.out.println("qwerty");
		int[] arrays = {0, 1, 2, 3, 4, 5, 6};
		Scanner s = new Scanner(System.in); 
		for(int i = 0; i < arrays.length; i++) {
			System.out.println("||亮1指示灯：" + arrays[i]);
			System.out.println("  判断红外线是否被挡住……");
			int button = 0;
			System.out.println("  没有红外线被挡住处于等待中……");
			button = s.nextInt();
			while(button != arrays[i]) {
				System.out.println("  红外线" + arrays[i] + "口没有被踩到，等待该口被踩…………");
				button = s.nextInt();
			}
			System.out.println("  红外线" + arrays[i] + "口有被踩到，进入下一步……\n");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestMap tm = new TestMap();
//		tm.testMusic();
//		tm.testHashMap1();
//		tm.testHashMap2();
//		tm.testLinkedHashMap();
//		tm.TestTreeMap1();
//		tm.TestTreeMap2();
		try {
			tm.testHashTable();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
