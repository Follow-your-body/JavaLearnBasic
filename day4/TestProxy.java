/*
设计模式
	代理模式
		为其他对象提供一种代理以控制对这个对象的访问
		通过接口的方式，通过另外一个类B，去访问类A（体现接口的多态性，可以拿不同类的对象来使用）
		练习：TestProxy.java
*/
package day3;

public class TestProxy {

	public static void main(String[] args) {
		ProxyObject p = new ProxyObject();
		p.getAction();
	}

}

interface Object{
	void getAction();
}

// 代理类
class ProxyObject implements Object {
	Object obj;
	
	public ProxyObject() {
		obj = new ObjectImpl();
		System.out.println("为被代理类创建成功");
	}

	@Override
	public void getAction() {
		System.out.println("被代理类开始执行");
		obj.getAction();
		System.out.println("被代理类结束执行");
			
	}
	
}

// 被代理类
class ObjectImpl implements Object {

	@Override
	public void getAction() {
		System.out.println("被代理模式开始");	
		System.out.println("这里为被代理模式");				
	}
	
}