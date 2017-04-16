/*
 * 用动态代理类的格式输出：
 * 	****************（静态）
 *     信息工程学院（静态）
 *  ****************（静态）
 *  	自动化（动态）
 *  ****************（静态）
 * */
package day17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface School {
	void perfession(String str);
}

// 被代理类
class Spcialty implements School {
	@Override
	public void perfession(String str) {
		System.out.println("      " + str);
	}
}

// 静态代理类
class Bift {
	public void bift1() {
		System.out.println("**********");
	}
	public void bift2() {
		System.out.println("  信息工程学院");
	}
}

// 代理类
class Proxy1 implements InvocationHandler {
	Object obj;
	// 获取被代理类对象
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
		school.perfession("自动化");
	}

}
