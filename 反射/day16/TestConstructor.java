package day16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestConstructor {
	
	// ����ָ���Ĺ�����
	@Test
	public void testConstructor1() throws Exception {
		Class c = Person.class;
		Constructor c1 = c.getDeclaredConstructor(String.class,int.class );
		c1.setAccessible(true);
		Person p = (Person)c1.newInstance("dayan", 24);
		System.out.println(p);		
	}
}
