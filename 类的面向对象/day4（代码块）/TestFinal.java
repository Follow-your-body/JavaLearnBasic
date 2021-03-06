/*
final关键字
	final标记的类不能被继承
	final标记的方法不能被子类重写
	final变量（成员变量+局部变量）即成为常量，名称大写，且只能被赋值一次
		此常量在哪里赋值：①此常量不能使用默认初始化 ②可以显式的赋值、代码块、构造器。
	练习：TestFinal.java
*/
package day3;

public class TestFinal {

	public static void main(String[] args) {
	}

}

class A1{
	final int i1 = 90;
	final double PI;
	final String NAME;
	// 代码块中初始化final常量
	{
		PI = 3.14;
	}	
	// 构造器中初始化final常量（final常量只能被赋值一次）
	public A1(double pI, String nAME) {
		super();
//		// The final field PI may already have been assigned
//		PI = pI;
		NAME = nAME;
	}


	final public void a1() {		
	}
	
}
//class B1 extends A1 {
//	/*
//	子类中不能修改父类的final修饰的方法
//	 Multiple markers at this line
//	- overrides day3.A1.a1
//	- Cannot override the final method 
//	*/ 
//	public void a1() {
//		
//	}
//}

final class A{	
}
//// he type B cannot subclass the final class A
//class B extends A{
//	
//}
