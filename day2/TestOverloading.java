/*
��Ա����������
	ͬһ�������з�������ͬ���βεĸ����������Ͳ�ͬ��˳��ͬҲ�㣩
	ע�⣺�����ط����ķ�������û�й�ϵ��Ҳ����˵����ֵ���Բ�ͬ��
	��ϰ��TestOverloading.java

 * �������ط���
 * ��һ����һ��int�βΣ�����β�ƽ�����
 * �ڶ���������int�βΣ��ֱ�����β�ƽ�����
 * ��������һ��String�βΣ�����β��ַ���
 * */
package com.lzw;

public class TestOverloading {
	static public void mOL(int i) {
		System.out.println("��һ�����غ������β�Ϊint���ͣ�����Ϊ1��ƽ���Ľ��Ϊ��" + i * i);
	}
	
	static public void mOL(int i, int j) {
		System.out.println("�ڶ������غ������β�Ϊint���ͣ�����Ϊ2����һ���βε�ƽ���Ľ��Ϊ��" + i * i
				+ ",�ڶ����βε�ƽ���Ľ��Ϊ��" + j * j);
	}
	
	static public void mOL(String i) {
		System.out.println("���������غ������β�ΪSting���ͣ�����Ϊ1���β�Ϊ��" + i);
	}

	public static void main(String[] args) {
		mOL(2);
		mOL(1,3);
		mOL("danay");
	}

}
