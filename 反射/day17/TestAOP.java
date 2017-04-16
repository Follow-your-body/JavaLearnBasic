package day17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
	void info();
	void fly();
}

// ��������
class SuperMan implements Human {
	@Override
	public void info() {
		System.out.println("���ǳ��ˣ���");
	}

	@Override
	public void fly() {
		System.out.println("�һ�ɣ���");
	}	
}

// �ṩ��̬����
class HumanUtil {
	public void method1() {
		System.out.println("����һ");
	}
	public void method2() {
		System.out.println("������");
	}
}

// ������
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

//��̬�Ĵ���һ��������Ķ���
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
