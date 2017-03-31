/*
接口(interface)
	来源：有时必须从几个派生类中生成一个子类，继承它们所有的属性和方法。
		但是Java 不支持多重继承。有了接口，就可以得到多重继承的效果
	组成：抽象方法+常量值定义的集合（不含变量+一般方法+构造器）
	实现接口类：class 类名 implements 接口{}
	特点：一个类可以实现多个接口，接口也可以继承其他接口（extends）
	练习：TestInterface.java
	总结
		通过接口可以实现不相关类的相同行为，而不需要考虑这些类之间的层次关系
		通过接口可以指明多个类需要实现的方法，一般用于对象的扩张功能
		接口主要用来定义规范，接触耦合关系
*/
package day3;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AA.I);
//		System.out.println(AA.I = 123);
	}

}

// 抽象方法+常量值定义的集合（不含变量+一般方法+构造器）
interface AA{
	//常量:所有的常量都用public static final修饰(一旦初始化之后，数值不可修改)
	int I = 12;
	boolean FLAG = false;
	//抽象方法:所有的都用public abstract修饰
	void method1();
	void method2();
//	// 不能含有变量+构造器（不能实例化）
//	int i;
//	public AA)(){		
//	}
}

interface MM{
	void method3();
}

//接口也可以继承其他接口（extends）
interface JJ extends MM,AA{
	void method4();
}

class DD{	
}

// 一个类可以实现多个接口(类继承+多接口)
class CC extends DD implements AA,MM{
	public void method1(){		
	}
	public void method2(){		
	}
	public void method3(){		
	}
}