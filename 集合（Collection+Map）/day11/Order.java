package day10;

import java.util.ArrayList;
import java.util.List;

// 定义泛型类(该类型是位置的，你可以自定一定你想要的类型)
public class Order<E> {
	private String orderName;
	private String orderId;
	private E t;
	List<E> list = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderId=" + orderId + ", t=" + t + "]";
	}

	public void add() {
		list.add(t);
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public E getT() {
		return t;
	}

	public void setT(E t) {
		this.t = t;
	}
	
	// 声明泛型方法(调用时指明既可)
	public <E> E getE(E e) {
		return e;
	}
	
	public static void show() {
		// 如果该类为泛型，类中使用到该泛型的泛型方法不能是static类型
		E e;
		System.out.println(e);
		// 不能再try-catch的形参中使用类中定义的泛型类型
		try {
			int i;
		} catch (E e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public <F> void setF(F f) {
		F f1 = f;
	}

}
