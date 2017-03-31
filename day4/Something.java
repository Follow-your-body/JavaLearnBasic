/*
final关键字
	final标记的类不能被继承
	final标记的方法不能被子类重写
	final变量（成员变量+局部变量）即成为常量，名称大写，且只能被赋值一次
		此常量在哪里赋值：①此常量不能使用默认初始化 ②可以显式的赋值、代码块、构造器。
	练习：TestFinal.java  Something.java
*/
package day3;

public class Something {
	public static void main(String[] args) {
		Other o = new Other();
		Something s = new Something();
//		s.addOne(12);
		new Something().addOne(o);
	}

	public void addOne(final Other o) {
		//o = null;
		System.out.println(o.i++);
	}

//	 public int addOne(final int x) {
//		 // The final local variable x cannot be assigned.
//		 return ++x;
//	 }
}

class Other {
	public int i;
}
