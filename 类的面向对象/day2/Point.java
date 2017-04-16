package com.lzw;

public class Point {
	//权限修饰符（成员变量+成员函数）
	private int x;
	private int y;
	private int z;
	
	// 构造函数
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;		
	}
	
	public void distant(Point p) {
		System.out.println("该点距离原点的距离为：" + 
	                Math.sqrt(p.x * p.x + p.y * p.y + p.z * p.z));		
	}

	public static void main(String[] args) {
		//通过创建一个新的构造器来创建该类的新对象
		Point p1 = new Point(2, 2, 2);
		p1.distant(p1);
	}

}
