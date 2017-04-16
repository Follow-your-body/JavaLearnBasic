package day16;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	void action();
}
// 被代理类
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("被代理类");		
	}	
}

// 代理类
class MyInvocationHandler implements InvocationHandler {
	Object obj;  // 实现了接口的被代理类的对象的声明
	// 给被代理类的对象实例化；返回一个代理类的对象
	public Object blind(Object obj) {
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}
	
	// 当通过代理类的对象发起被重写的调用时，都会转化为对invoke方法的调用
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// method方法的返回值returnVal
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
	
}


public class TestProxy{
	
	public static void main(String[] args) {
		// 创建一个被代理类的对象
		RealSubject rs = new RealSubject();		
		// 创建一个实现了invokecationHandler接口的类的对象		
		MyInvocationHandler mih = new MyInvocationHandler();
		
		// 调用blind（），动态的返回一个同样实现了real所在类实现的接口Subject的代理类的对象，
		Object obj = mih.blind(rs);
		
		Subject sub = (Subject)obj;  // 此时的sub就是代理类的对象
		
		sub.action();  //转到对MyInvocationHandler实现类的invoke方法的调用
	}
	
}

