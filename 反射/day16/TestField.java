package day16;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	
	// 获取对应的运行时类的属性
	@Test
	public void testField1() {
		Class c1 = Person.class;
		
		// 1.getFields()：获取运行时类（还有父类）中声明为public的属性（只有name属性）
		Field[] field = c1.getFields();
		for(int i = 0; i < field.length; i++) {
			System.out.println(field[i]);
		}
		// 2.getDeclaredFields()：获取运行时类(没有父类)中所有的属性
		Field[] field1 = c1.getDeclaredFields();
		for(Field i: field1) {
			System.out.println(i);
		}
	}
	
	// 获取属性的类型：权限修饰符+变量类型+变量名
	@Test
	public void testField2() {
		Class c1 = Person.class;
		Field[] field = c1.getDeclaredFields();
		for(Field i: field){
			// 1.获取每个属性的权限修饰符
			String str1 = Modifier.toString(i.getModifiers());
			System.out.println(i + ": "+ str1);
			// 2.获取属性的类型
			Class type = i.getType();
			System.out.println(i + ":" + type);
			// 3.获取变量名(私有的)
			System.out.println(i + ": " + i.getName());
		}		
	}
	
	// 调用属性中指定的属性
	@Test
	public void testField3() throws Exception {
		Class c = Person.class;
		// 获取指定的属性
		Field name = c.getField("name");
		Field age = c.getDeclaredField("age");
		// 创建运行时类的对象
		Person p = (Person) c.newInstance();
		System.out.println(p);
		// 将运行时类的指定的属性赋值(public)
		name.set(p, "danay");
		System.out.println(p);
		// 将运行时类的指定的属性赋值(private )
		age.setAccessible(true);
		age.set(p, 23);
		System.out.println(p);		
	}

}
