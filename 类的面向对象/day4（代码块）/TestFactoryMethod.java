/*
设计模式
		工厂方法
			定义一个用于创建对象的接口，让子类决定实例化哪一个类
				，FactoryMethod使一个类的实例化延迟到其子类
			适用性
				当一个类不知道它必须创建的对象的类的时候
				当一个类希望由它的子类来指定它所创建的对象的时候
				当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望
					将哪一个帮助子类是代理者这一信息局部化的时候
			练习：TestFactoryMethod.java
*/
package day3;

public class TestFactoryMethod {

	public static void main(String[] args) {
		// 多态性（实例化的对象对应的类不同）
		IWorkFactory i1 = new StudentFactory();
		i1.getWork().doWork();
		IWorkFactory i2 = new TeacherFactory();
		i2.getWork().doWork();
	}

}

// 简单的借口（抽象画方法--工作内容）
interface Work {
	void doWork();
}

class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("学生负责写作业+听课");		
	}
	
}

class TeacherWork implements Work {

	@Override
	public void doWork() {
		System.out.println("老师负责改作业+讲课");		
	}
	
}

// 获取对应的对象类的对象，返回的时为什么是Work这个我有点不太明白？？？？
interface IWorkFactory {
	Work getWork();
}

class StudentFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		// TODO Auto-generated method stub
		return new StudentWork();
	}
	
}

class TeacherFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		// TODO Auto-generated method stub
		return new TeacherWork();
	}
	
}