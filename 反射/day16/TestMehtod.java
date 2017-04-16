package day16;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class TestMehtod {
	
	private Class String;

	// 获取方法
	@Test
	public void testMehtod1() {
		Class c = Person.class;
		
		// 1.getMethods()：获取运行时类（还有父类）中声明为public的方法
		Method[] methods = c.getMethods();
		for(Method method: methods) {
			System.out.println(method);
		}
		
		System.out.println();
		
		// 2.getDeclaredMethods():获取运行时类（不包含父类）的所有方法
		Method[] methods1 = c.getDeclaredMethods();
		for(Method method: methods1) {
			System.out.println(method);
		}
		
	}
	
	// 获取方法的属性：修饰符+返回值类型+形参列表+注解+异常
	@Test
	public void testMehtod2() {
		Class c = Person.class;
		Method[] methods = c.getDeclaredMethods();
		for(Method method: methods) {
			
			// 1.注解
			Annotation[] annotations = method.getAnnotations();
			for(Annotation annotation: annotations) {
				System.out.println(annotation);
			}
			
			// 2.修饰符
			String str1 = Modifier.toString(method.getModifiers());
			System.out.print(str1 + " ");
			
			// 3.返回值类型
			System.out.print(method.getReturnType() + " ");
			
			// 4.获取名称
			String str = method.getName();
			System.out.print(str + " ");
			
			// 5.形参的名称+返回值类型
			Parameter[] parameters = method.getParameters();
			for(Parameter parameter: parameters) {
//				// 5.1形参的名称
//				parameter.getName();
				System.out.print(parameter + " ");
			}
			
//			// 5.2. 形参列表的数据类型
//			Class<?>[] parameterTypes = method.getParameterTypes();
//			for(Class parameterType: parameterTypes) {
//				System.out.print(parameterType + " ");
//			}
			
			// 6.抛异常
			Class<?>[] exceptions = method.getExceptionTypes();
			for(Class exception: exceptions) {
				System.out.println(exception);
			}			
			System.out.println();						
		}
	}
	
	// 获取运行时中指定的方法
	@Test
	public void testMehtod3() throws Exception {
		Class c = Person.class;
		
		// getMethod（）：根据名称获取类中private的方法
		Method m1 = c.getMethod("show");
		Method m2 = c.getDeclaredMethod("display", String.class);
		Person p = (Person)c.newInstance();
		
		// invoke（）：反射调用对象中的方法(私有需要加setAccessible(true))
		m1.invoke(p);
		m2.setAccessible(true);
		m2.invoke(p, "china");
		
		//静态方法的调用
		Method m3 = c.getMethod("info");
		m3.invoke(Person.class);
	}
	

}
