/*
抽象类
	定义：将一个父类设计的非常抽象，以至于没有具体的实例，这样的类叫做抽象类
	abstract修饰类：抽象类
		不可实例化
		抽象类有构造器（废话）
		抽象方法所在的类一定是抽象类
		抽象类中可以没有抽象方法
	abstract修饰方法：抽象方法
		格式：没有方法体，包括{}，如breath方法
		只能保留方法的功能，而具体的执行，交给继承类的子类
			，由子类重写此抽象方法
		若子类继承抽象类，并重写所有的抽象方法，则此类是一个实体类，
			既可以实例化，如Student类
		若子类继承抽象类，没有重写所有的抽象方法，意味着此类中仍有抽象方法
			，则此类必须声明为抽象类，如Person类
	abstract 不能用来修饰属性、构造器、private、final、static
	练习：TestAbstract.java
*/
package day3;

public class TestAbstract {

	public static void main(String[] args) {
//		// Cannot instantiate the type Creator(抽象类不能实例化)
//		Creator c = new Creator();
		Student s = new Student();
		s.breath("学生", "鼻子");
		s.walk("学生", "用腿走路");
		s.eat("学生", "面包+牛奶");
		Worker w = new Worker();
		w.breath("工人", "不知道");
		s.walk("工人", "不知道");
		w.eat("工人", "不知道");
	}

}

// 抽象方法所在的类一定是抽象类(The type Creator must be an abstract class to define abstract methods)
abstract class Creator {
	abstract void breath(String name, String meathod);	
}

abstract class Person extends Creator{
//	// only public, protected, private, static, final,transient & volatile are permitted
//	abstract int personId;
	private String name;
	abstract void walk(String name, String meathod);
	abstract void eat(String name, String food);
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

class Student extends Person{
	void walk(String name, String meathod) {
		System.out.println(name + "走路的方式为" + meathod + "!!");
	}
	void eat(String name, String food) {
		System.out.println(name + "吃的食物有" + food + "!!");
	}
	// 
	@Override
	void breath(String name, String meathod) {
		System.out.println(name + "用" + meathod + "呼吸！！");		
	}	
}

class Worker extends Person{
	void walk(String name, String meathod) {
		System.out.println("公认的额走路方式不知道！");
	}
	void eat(String name, String food) {
		System.out.println("工人吃的食物也不知道！");
	}
	@Override
	void breath(String name, String meathod) {
		System.out.println("工人的呼吸方式也不知道！");		
	}	
}