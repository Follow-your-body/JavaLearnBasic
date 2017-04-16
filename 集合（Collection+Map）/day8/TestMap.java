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
	 ��ӡ�ɾ������
			Object put(OBject key, Object value)
			Object remove(Object key)
			void putAll(Map t)
			void clear()
	Ԫ��ͼ�����ķ���
			Set keySet()��keyʹ��set����ŵģ������ظ�
			Collection values()��value����Colltion����ŵģ����ظ�	
			Set entrySet()��key-value�ԣ���һ��entry�����е�entryʹ��Set��ţ�Ҳ�����ظ�
	Ԫ�ز�ѯ�Ĳ���
			Object get��Object key��
			boolean containsKey(Object key)
			boolean containsValue(Object value)
			int size()
			boolean isEmpty()
			boolean equals(Object obj) 
						
	HashMap:keyʹ��set����ŵģ������ظ�;
			value����Colltion����ŵģ����ظ�			
			key-value�ԣ���һ��entry�����е�entryʹ��Set��ţ�Ҳ�����ظ�
			key��value������Ϊnull			
			��HashMap�����Ԫ��ʱ�������Key�������equals�������ж�����key�Ƿ���ͬ������ͬ�������
			HashCode��equals����Ҫ��д
			LinkedHashMap��HashMap��ͬ��ֻ�Ǵ洢��ʱ��ͬ����
	TreeMap������key��һ�������Խ�������
	
	 */
	@Test
	public void testHashMap1() {
		System.out.println("��Ӷ��󡭡���������");
		Map map = new HashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value�ԣ���һ��entry�����е�entryʹ��Set��ţ�Ҳ�����ظ�
		map.put("AA", 2013);	// keyʹ��set����ŵģ������ظ�;
		map.put("CC", 2014);
		map.put("BB", 2013);
		map.put("DD", 2015);
		map.put("EE", null);	// key��value������Ϊnull
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		System.out.println("ɾ�����󡭡���������");
		map.remove(null);
		System.out.println(map);
		
		System.out.println("��ն��󡭡���������");
		map.clear();
		System.out.println(map);		
	}
	
	public void testHashMap2() {
		System.out.println("��Ӷ��󡭡�������˳�����롭������");
		Map map = new HashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value�ԣ���һ��entry�����е�entryʹ��Set��ţ�Ҳ�����ظ�
		map.put("AA", 2013);	// keyʹ��set����ŵģ������ظ�;
		map.put("CC", 2014);
		map.put("BB", 2013);
		map.put("EE", null);	// key��value������Ϊnull
		map.put("DD", 2015);
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		System.out.println("����key������");  // key�ǰ�Set���ϴ洢
		Set set = map.keySet();
		for(Object obj : set) {
			System.out.println(obj);			
		}
		
		System.out.println("����value������"); // value�ǰ�collection���ϴ洢
		Collection values = map.values();
		for(Object obj : values) {
			System.out.println(obj);			
		}
		
		System.out.println("����key-value�ԣ���ʽһ����"); // value�ǰ�collection���ϴ洢
		Set set1 = map.keySet();
		for(Object obj : set1) {
			System.out.println(obj +"-->" + map.get(obj));			
		}
		
		System.out.println("����key-value��,��ʽ������"); // value�ǰ�collection���ϴ洢
		Set set2 = map.entrySet();
		for(Object obj : set2) {
			System.out.println(obj);			
		}
	}
	
	@Test
	public void testLinkedHashMap() {
		System.out.println("��Ӷ��󡭡������������򡭡���");
		Map map = new LinkedHashMap();
		map.put("AA", 2013);   
		map.put("AA", 2013);	// key-value�ԣ���һ��entry�����е�entryʹ��Set��ţ�Ҳ�����ظ�
		map.put("AA", 2013);	// keyʹ��set����ŵģ������ظ�;
		map.put("DD", 2015);
		map.put("BB", 2013);
		map.put("CC", 2014);
		map.put("EE", null);	// key��value������Ϊnull
		map.put(null, null);		
		map.put(new Person("dayna", 32), 2013);
		map.put(new Person("dayna", 32), 2014);
		System.out.println(map);
		
		// ʹ��������ӽ�Map�е�˳�򣬹ʱ���Mapʱ��ʱ������ӵ�˳��
		System.out.println("����key������");  // key�ǰ�Set���ϴ洢
		Set set = map.keySet();
		for(Object obj : set) {
			System.out.println(obj);			
		}
	}
		
	public void TestTreeMap1() {
		System.out.println("<TestTreeMap�����>");
		System.out.println("��Ӷ��󡭡�������˳���Զ��ı䣨�����������䣩������");
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
		System.out.println("<TestTreeMap�����>");
		System.out.println("��Ӷ��󡭡����Զ���key���������������������������");
		// �Ȱ�����Ȼ����������
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
		// ʹ��Properties���Դ������ļ�����
		Properties pros = new Properties();
		pros.load(new FileInputStream(new File("jdbc.properties")));
		String user = pros.getProperty("user");
		System.out.println(user);
		String password = pros.getProperty("password");
		System.out.println(password);
	}
	
	
	@Test
	public void testMusic () {
		System.out.println(4 ^ 4);  // ^Ϊ���
		System.out.println("qwerty");
		int[] arrays = {0, 1, 2, 3, 4, 5, 6};
		Scanner s = new Scanner(System.in); 
		for(int i = 0; i < arrays.length; i++) {
			System.out.println("||��1ָʾ�ƣ�" + arrays[i]);
			System.out.println("  �жϺ������Ƿ񱻵�ס����");
			int button = 0;
			System.out.println("  û�к����߱���ס���ڵȴ��С���");
			button = s.nextInt();
			while(button != arrays[i]) {
				System.out.println("  ������" + arrays[i] + "��û�б��ȵ����ȴ��ÿڱ��ȡ�������");
				button = s.nextInt();
			}
			System.out.println("  ������" + arrays[i] + "���б��ȵ���������һ������\n");
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
