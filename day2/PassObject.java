/*
�������Ϊ�β�+���������
		���������
			ֻ��Ҫ����һ����Ķ���ʱ����
			ֻ�ܵ���һ��
		��ϰPassObject.java Circle.java
*/
package com.lzw;

public class PassObject {
	// �������Ϊ��Ա�������β�
	static public void printAreas(Circle c, int time) {
		for(int i = 1; i <= time; i++) {
			c.setRadius(i);
			System.out.println(i + "�����Ϊ��" + c.findArea());
		}
	}

	public static void main(String[] args) {
		// �������������
		printAreas(new Circle(), 4);
	}

}
