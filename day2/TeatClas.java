/* 1���������ı�̹�ע��������
 * 2���������������ĳ�Ա
 * 3����������ĳ�Ա������&����
 * */
package com.lzw;

public class TestPerson {
	// 1,����(��Ա����)
	String name;
	int age;
	boolean sex;
	
	// 2����������Ա������
	public void eat() {
		int fruit; // �ֲ�����
		System.out.println("�˳Է�");
	}
	public void sleep() {
		System.out.println("��˯��");
	}
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		TestPerson tp = new TestPerson();  // ������Ķ���
		tp.age = 12;            // ����ʵ����Ӧ�Ĺ��ܣ���Ա������
		tp.name = "danay";		
	}

}
