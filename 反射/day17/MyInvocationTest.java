/*
 * �ö�̬������ĸ�ʽ�����
 * 	****************����̬��
 *     ��Ϣ����ѧԺ����̬��
 *  ****************����̬��
 *  	�Զ�������̬��
 *  ****************����̬��
 * */
package day17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface School {
	void perfession(String str);
}

// ��������
class Spcialty implements School {
	@Override
	public void perfession(String str) {
		System.out.println("      " + str);
	}
}

// ��̬������
class Bift {
	public void bift1() {
		System.out.println("**********");
	}
	public void bift2() {
		System.out.println("  ��Ϣ����ѧԺ");
	}
}

// ������
class Proxy1 implements InvocationHandler {
	Object obj;
	// ��ȡ�����������
	public Object getProxy(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Bift bift = new Bift();
		bift.bift1();
		bift.bift2();
		bift.bift1();
		Object returnVal = method.invoke(obj, args);
		bift.bift1();
		return returnVal;
	}	
}


public class MyInvocationTest {
	public static void main(String[] args) {
		Spcialty spcialty = new Spcialty();
		Proxy1 proxy = new Proxy1();
		Object obj = proxy.getProxy(spcialty);
		School school = (School)obj;
		school.perfession("�Զ���");
	}

}
