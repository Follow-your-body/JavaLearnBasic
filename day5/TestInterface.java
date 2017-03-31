/*
 * ����һ���ӿ�����ʵ����������ıȽϡ�
 interface CompareObject{
 public int compareTo(Object o);   //������ֵ�� 0 , �������; ��Ϊ����������ǰ����󣻸�������ǰ����С
 }
 ����һ��Circle�ࡣ

 ����һ��ComparableCircle�࣬�̳�Circle�ಢ��ʵ��CompareObject�ӿڡ�
 ��ComparableCircle���и����ӿ��з���compareTo��ʵ���壬�����Ƚ�����Բ�İ뾶��С��

 ����һ��������TestCircle����������ComparableCircle����
 ����compareTo�����Ƚ�������İ뾶��С��

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
	// ��ͬ����0����ǰ����󷵻�ֵΪ��������ǰ����С����ֵΪ����
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