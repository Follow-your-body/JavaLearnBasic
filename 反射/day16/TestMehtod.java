package day16;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class TestMehtod {
	
	private Class String;

	// ��ȡ����
	@Test
	public void testMehtod1() {
		Class c = Person.class;
		
		// 1.getMethods()����ȡ����ʱ�ࣨ���и��ࣩ������Ϊpublic�ķ���
		Method[] methods = c.getMethods();
		for(Method method: methods) {
			System.out.println(method);
		}
		
		System.out.println();
		
		// 2.getDeclaredMethods():��ȡ����ʱ�ࣨ���������ࣩ�����з���
		Method[] methods1 = c.getDeclaredMethods();
		for(Method method: methods1) {
			System.out.println(method);
		}
		
	}
	
	// ��ȡ���������ԣ����η�+����ֵ����+�β��б�+ע��+�쳣
	@Test
	public void testMehtod2() {
		Class c = Person.class;
		Method[] methods = c.getDeclaredMethods();
		for(Method method: methods) {
			
			// 1.ע��
			Annotation[] annotations = method.getAnnotations();
			for(Annotation annotation: annotations) {
				System.out.println(annotation);
			}
			
			// 2.���η�
			String str1 = Modifier.toString(method.getModifiers());
			System.out.print(str1 + " ");
			
			// 3.����ֵ����
			System.out.print(method.getReturnType() + " ");
			
			// 4.��ȡ����
			String str = method.getName();
			System.out.print(str + " ");
			
			// 5.�βε�����+����ֵ����
			Parameter[] parameters = method.getParameters();
			for(Parameter parameter: parameters) {
//				// 5.1�βε�����
//				parameter.getName();
				System.out.print(parameter + " ");
			}
			
//			// 5.2. �β��б����������
//			Class<?>[] parameterTypes = method.getParameterTypes();
//			for(Class parameterType: parameterTypes) {
//				System.out.print(parameterType + " ");
//			}
			
			// 6.���쳣
			Class<?>[] exceptions = method.getExceptionTypes();
			for(Class exception: exceptions) {
				System.out.println(exception);
			}			
			System.out.println();						
		}
	}
	
	// ��ȡ����ʱ��ָ���ķ���
	@Test
	public void testMehtod3() throws Exception {
		Class c = Person.class;
		
		// getMethod�������������ƻ�ȡ����private�ķ���
		Method m1 = c.getMethod("show");
		Method m2 = c.getDeclaredMethod("display", String.class);
		Person p = (Person)c.newInstance();
		
		// invoke������������ö����еķ���(˽����Ҫ��setAccessible(true))
		m1.invoke(p);
		m2.setAccessible(true);
		m2.invoke(p, "china");
		
		//��̬�����ĵ���
		Method m3 = c.getMethod("info");
		m3.invoke(Person.class);
	}
	

}
