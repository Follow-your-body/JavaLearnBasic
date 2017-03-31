/*
类的成员之四：初始化快
	分类
		静态代码块
		非静态代码块（没有static修饰
		相同
			可以有输出语句
			可以对类的属性+类的声明进行初始化操作
			可以按照从上到下的顺序依次执行
		不同
			静态代码块
				不可以对非静态的属性（属性+方法）初始化
				静态代码块的执行要先于非静态代码块
				静态代码块只执行一次
			非静态代码块（没有static修饰）
				每一创建对象的时候都会执行一次，且先于构造器执行
		程序自己创建类中的属性方法
			左击“Source”
				创建接口
				生成getter和setter方法

				生成toString()方法
				生成hashCode()+equals()方法
				生成构造函数方法
		练习：TestOrder.java
*/
package day3;

public class TestOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order o1= new Order();
		System.out.println(o1);
		Order o2= new Order();
		System.out.println(o2);
	}

}

class Order {
	private int orderId;
	private String orderName;
	private static String orderDesc;
	// 非静态初始化块（没有限制）
	{
		orderId = 1002;  // 非静态属性初始化
		orderName = "a";
		System.out.println("非静态初始化块!!"); // 输出语句
		orderDesc = "orderDesc"; // 静态属性初始化
		show1();  // 非静态方法调用
		show2();		
	}
	// 静态初始化（只能输出花静态属性+静态方法+输出语句）
	{
		System.out.println("静态初始化块!!"); // 输出语句
		orderDesc = "orderDesc"; // 静态属性初始化
		show2(); // 静态方法初始化
	}
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void show1(){
		
	}
	public static void show2(){
		
	}	
	
}
