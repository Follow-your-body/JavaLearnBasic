package IO;

import org.junit.Test;

public class day13 {
	@Test
	public void test1() {
		C c1 = new C();
		B b1 = new C();   // 向上转型
		
		B b2 = new B();   // 向下转型	
		C c2 = (C)b2;
		
		A a1 = new A();   // 向下转型（父父类）
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
