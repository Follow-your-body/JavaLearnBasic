package day16;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}
// ��������
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("��������");		
	}	
}

// ������
class MyInvocationHandler implements InvocationHandler {
	Object obj;  // ʵ���˽ӿڵı�������Ķ��������
	// ����������Ķ���ʵ����������һ��������Ķ���
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}
	
	// ��ͨ��������Ķ�������д�ĵ���ʱ������ת��Ϊ��invoke�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// method�����ķ���ֵreturnVal
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
	
}


public class TestProxy{
	
	public static void main(String[] args) {
		// ����һ����������Ķ���
		RealSubject rs = new RealSubject();		
		// ����һ��ʵ����invokecationHandler�ӿڵ���Ķ���		
		MyInvocationHandler mih = new MyInvocationHandler();
		
		// ����blind��������̬�ķ���һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ�����Ķ���
		Object obj = mih.blind(rs);
		
		Subject sub = (Subject)obj;  // ��ʱ��sub���Ǵ�����Ķ���
		
		sub.action();  //ת����MyInvocationHandlerʵ�����invoke�����ĵ���
	}
	
}

