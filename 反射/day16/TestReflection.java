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
	
	// 在有反射之前如何创建一个类的对象+调用其中的方法、属性
	@Test
	public void test() {
		Person p = new Person();
		p.setAge(12);
		p.setName("danay");
		System.out.println(p);
		p.show();
		p.display("WC");
	}
	
	// 有了反射，可以通过反射调用一个类的对象+调用其中的方法、属性
	@Test
	public void test1() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		Class<Person> c = Person.class;
		
		// 1.创建c对应的运行时类的对象
		Person p = c.newInstance();
		System.out.println(p);
		
		// 2.调用指定属性（public+private）
		Field f1 = c.getField("name");
		f1.set(p, "anna");
		System.out.println(p);
		Field f2 = c.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 12);
		
		// 3.调用指定方法
		Method m1 = c.getMethod("show");
		m1.invoke(p);
		Method m2 = c.getMethod("display", String.class);
		m2.invoke(p, "china");
	}
	
	/*
	 java.lang.Class：是反射的源头（获取对象+Field+Method+包+注解）	
	 创建了一个类，通过编译(javac.exe)生成对应的.calss文件（编译的过程），之后使用使用Java.exe加载（Java虚拟机的类加载器）
	 此.class文件。 此.java文件加载到内存之后，就是一个运行时类，存在在缓存区。那么这个运行时类本身就是一个Class文件
	注意：每一个运行时类只加载一次！ 有了Class之后我们才可以运行一下的操作
	1.创建对应运行时类Person类的对象
	2.获取对应运行时类的结构（属性+方法+构造器+内部类+所在的包+父类等）
	3.调用运行时类的指定的结构（属性+方法+构造器+内部类+所在的包+父类等）
	4.反射的应用：动态代理
	 */
	@Test
	public void test3() {
		Person p = new Person();
		Class c = p.getClass();  // 通过呢运行时类的对象调用其getClass（）方法，返回运行时类
		System.out.println(c);  // class day16.Person
		
	}
	
	/*
	 1.如何获取Class的实例（3种）
	 */
	@Test
	public void test4() throws ClassNotFoundException {
		// 1.调用运行时类本身的.Class属性(自己定义+本身就有)
		Class<Person> c1 = Person.class;
		System.out.println(c1.getName());		
		Class c2 = String.class;
		System.out.println(c2);
		
		// 2.通过运行时类的对象获取
		Person p = new Person();
		Class c3 = p.getClass();
		System.out.println(c3.getName());
		
		// 3.通过Class的静态方法
		String className = "day16.Person";
		Class c4 = Class.forName(className);
		System.out.println(c4.getName());
		
		// 4.通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?> c5 = classLoader.loadClass(className);
		System.out.println(c5.getName());
	}
	
	// 关于类的加载器
	@Test
	public void test5() {
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1);
		
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2);
		
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3);
		
		// 加载器能干什么(获取具体包下的文件,而在是对应工程下的文件)
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
