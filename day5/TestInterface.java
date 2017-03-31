/*
 * 定义一个接口用来实现两个对象的比较。
 interface CompareObject{
 public int compareTo(Object o);   //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
 }
 定义一个Circle类。

 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。

 定义一个测试类TestCircle，创建两个ComparableCircle对象，
 调用compareTo方法比较两个类的半径大小。

 */
package day5;

public class TestInterface {

	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(10);
		ComparableCircle c2 = new ComparableCircle(20);
		System.out.println(c2.compareTo(c1));
	}

}

interface CompareObject {
	// 相同返回0，当前对象大返回值为正数，当前对象小返回值为负数
	int compareTo(Object o);
}

class Circle {
	private float radius;

	public Circle() {
		super();
	}

	public Circle(float radius) {
		super();
		this.radius = radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
		
}

class ComparableCircle extends Circle implements CompareObject {
	
	public ComparableCircle() {
		super();
	}
	
	public ComparableCircle(float radius) {
		super(radius);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof ComparableCircle) {
			ComparableCircle c = (ComparableCircle)o;
			if(this.getRadius() > c.getRadius()) {
				return 1;
			}else if(this.getRadius() < c.getRadius()) {
				return -1;
			}			
		}
		return 0;
	}
	
}