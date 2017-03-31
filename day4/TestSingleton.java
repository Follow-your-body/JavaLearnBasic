/*
设计模式（23种）
	单例设计模式
		目的：使得类只能创建一个实例
		方法
			饿汉式
				将构造函数的修饰改为private
				类中创建实例变量instance(实例化的别名)
				类中创建获取该对象的public方法
				注：调用时是能类调用，所以instance+获取该对象的方法都为static
				练习：TestSingleton.java
			懒汉式
				将构造函数的修饰改为private
				类中声明实例变量instance(实例化的别名)，不创建
				类中创建获取该对象的public方法，在其中判断声明中是否创建，如果没有创建一个新的实例
				注：调用时是能类调用，所以instance+获取该对象的方法都为static
				练习：TestSingleton1.java
*/
package day3;

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s1 == s2);  //判断两个别名是不是同一个实例

	}
}

class Singleton {
	private static Singleton instance = new Singleton();
	// 私有化构造器（在类外不能调用，想创建对象只能在该类的内部创建）
	private Singleton () {
	}
	// 提供公共的方法来调用该对象(因为不能实例化，所以只能用该类来调：static)
	public static Singleton getSingleton() {
		return instance;
	}
}
