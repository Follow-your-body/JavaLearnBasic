package IO;

import org.junit.Test;

public class day13 {
	@Test
	public void test1() {
		C c1 = new C();
		B b1 = new C();   // ����ת��
		
		B b2 = new B();   // ����ת��	
		C c2 = (C)b2;
		
		A a1 = new A();   // ����ת�ͣ������ࣩ
		C c3 = (C)a1;
		
		A a2 = new C();
		
		
	}
	

}

interface AA {
	int A1 = 2;    // pubic+final+static
	public void testInterface();   // public + abstract
}

abstract class A implements AA{
	
	abstract public void testA();

	
	public void testInterface() {
		
		
	}
}

class B extends A{
	public void B(){
	}	
}

class C extends B {
	public void C() {
		
	}	
}
