package com.lzw;

public class Point {
	//Ȩ�����η�����Ա����+��Ա������
	private int x;
	private int y;
	private int z;
	
	// ���캯��
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;		
	}
	
	public void distant(Point p) {
		System.out.println("�õ����ԭ��ľ���Ϊ��" + 
	                Math.sqrt(p.x * p.x + p.y * p.y + p.z * p.z));		
	}

	public static void main(String[] args) {
		//ͨ������һ���µĹ�����������������¶���
		Point p1 = new Point(2, 2, 2);
		p1.distant(p1);
	}

}
