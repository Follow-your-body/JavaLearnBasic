package day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	
	// ���з���֮ǰ��δ���һ����Ķ���+�������еķ���������
	@Test
	public void test() {
		Person p = new Person();
		p.setAge(12);
		p.setName("danay");
		System.out.println(p);
		p.show();
		p.display("WC");
	}
	
	// ���˷��䣬����ͨ���������һ����Ķ���+�������еķ���������
	@Test
	public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<Person> c = Person.class;
		
		// 1.����c��Ӧ������ʱ��Ķ���
		Person p = c.newInstance();
		System.out.println(p);
		
		// 2.����ָ�����ԣ�public+private��
		Field f1 = c.getField("name");
		f1.set(p, "anna");
		System.out.println(p);
		Field f2 = c.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 12);
		
		// 3.����ָ������
		Method m1 = c.getMethod("show");
		m1.invoke(p);
		Method m2 = c.getMethod("display", String.class);
		m2.invoke(p, "china");
	}
	
	/*
	 java.lang.Class���Ƿ����Դͷ����ȡ����+Field+Method+��+ע�⣩	
	 ������һ���࣬ͨ������(javac.exe)���ɶ�Ӧ��.calss�ļ�������Ĺ��̣���֮��ʹ��ʹ��Java.exe���أ�Java����������������
	 ��.class�ļ��� ��.java�ļ����ص��ڴ�֮�󣬾���һ������ʱ�࣬�����ڻ���������ô�������ʱ�౾�����һ��Class�ļ�
	ע�⣺ÿһ������ʱ��ֻ����һ�Σ� ����Class֮�����ǲſ�������һ�µĲ���
	1.������Ӧ����ʱ��Person��Ķ���
	2.��ȡ��Ӧ����ʱ��Ľṹ������+����+������+�ڲ���+���ڵİ�+����ȣ�
	3.��������ʱ���ָ���Ľṹ������+����+������+�ڲ���+���ڵİ�+����ȣ�
	4.�����Ӧ�ã���̬����
	 */
	@Test
	public void test3() {
		Person p = new Person();
		Class c = p.getClass();  // ͨ��������ʱ��Ķ��������getClass������������������ʱ��
		System.out.println(c);  // class day16.Person
		
	}
	
	/*
	 1.��λ�ȡClass��ʵ����3�֣�
	 */
	@Test
	public void test4() throws ClassNotFoundException {
		// 1.��������ʱ�౾���.Class����(�Լ�����+�������)
		Class<Person> c1 = Person.class;
		System.out.println(c1.getName());		
		Class c2 = String.class;
		System.out.println(c2);
		
		// 2.ͨ������ʱ��Ķ����ȡ
		Person p = new Person();
		Class c3 = p.getClass();
		System.out.println(c3.getName());
		
		// 3.ͨ��Class�ľ�̬����
		String className = "day16.Person";
		Class c4 = Class.forName(className);
		System.out.println(c4.getName());
		
		// 4.ͨ����ļ�����
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?> c5 = classLoader.loadClass(className);
		System.out.println(c5.getName());
	}
	
	// ������ļ�����
	@Test
	public void test5() {
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
		
		// �������ܸ�ʲô(��ȡ������µ��ļ�,�����Ƕ�Ӧ�����µ��ļ�)
		ClassLoader loader4 = this.getClass().getClassLoader();
		BufferedReader br = null;
		try {
			InputStream is = loader4.getResourceAsStream("day16\\test.txt");
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
