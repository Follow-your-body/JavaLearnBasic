package day10;

import java.util.ArrayList;
import java.util.List;

// ���巺����(��������λ�õģ�������Զ�һ������Ҫ������)
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

}
