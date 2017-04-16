package day16;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	
	// ��ȡ��Ӧ������ʱ�������
	@Test
	public void testField1() {
		Class c1 = Person.class;
		
		// 1.getFields()����ȡ����ʱ�ࣨ���и��ࣩ������Ϊpublic�����ԣ�ֻ��name���ԣ�
		Field[] field = c1.getFields();
		for(int i = 0; i < field.length; i++) {
			System.out.println(field[i]);
		}
		// 2.getDeclaredFields()����ȡ����ʱ��(û�и���)�����е�����
		Field[] field1 = c1.getDeclaredFields();
		for(Field i: field1) {
			System.out.println(i);
		}
	}
	
	// ��ȡ���Ե����ͣ�Ȩ�����η�+��������+������
	@Test
	public void testField2() {
		Class c1 = Person.class;
		Field[] field = c1.getDeclaredFields();
		for(Field i: field){
			// 1.��ȡÿ�����Ե�Ȩ�����η�
			String str1 = Modifier.toString(i.getModifiers());
			System.out.println(i + ": "+ str1);
			// 2.��ȡ���Ե�����
			Class type = i.getType();
			System.out.println(i + ":" + type);
			// 3.��ȡ������(˽�е�)
			System.out.println(i + ": " + i.getName());
		}		
	}
	
	// ����������ָ��������
	@Test
	public void testField3() throws Exception {
		Class c = Person.class;
		// ��ȡָ��������
		Field name = c.getField("name");
		Field age = c.getDeclaredField("age");
		// ��������ʱ��Ķ���
		Person p = (Person) c.newInstance();
		System.out.println(p);
		// ������ʱ���ָ�������Ը�ֵ(public)
		name.set(p, "danay");
		System.out.println(p);
		// ������ʱ���ָ�������Ը�ֵ(private )
		age.setAccessible(true);
		age.set(p, 23);
		System.out.println(p);		
	}

}
