package day17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();
	void fly();
}

// 被代理类
class SuperMan implements Human {
	@Override
	public void info() {
		System.out.println("我是超人！！");
	}

	@Override
	public void fly() {
		System.out.println("我会飞！！");
	}	
}

// 提供静态方法
class HumanUtil {
	public void method1() {
		System.out.println("方法一");
	}
	public void method2() {
		System.out.println("方法二");
	}
}

// 代理类
class MyInvocationHandler implements InvocationHandler {
	Object obj;
	public void setObject(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumanUtil hu = new HumanUtil();
		hu.method1();
		
		Object returnVal = method.invoke(obj, args);
		
		hu.method2();
		
		System.out.println();
		return returnVal;
	}	
}

//动态的创建一个代理类的对象
class MyProxy {
	public static Object getProxyInstance(Object obj) {
		MyInvocationHandler mih = new MyInvocationHandler();
		mih.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().
				getClassLoader(), obj.getClass().getInterfaces(), mih);
	}
}

public class TestAOP {
	public static void main(String[] args) {
		SuperMan sm = new SuperMan();
		Object obj = MyProxy.getProxyInstance(sm);
		Human h = (Human) obj;
		h.fly();
		h.info();
	}
}
