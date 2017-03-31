/*
���ģʽ��23�֣�
	�������ģʽ
		Ŀ�ģ�ʹ����ֻ�ܴ���һ��ʵ��
		����
			����ʽ
				�����캯�������θ�Ϊprivate
				���д���ʵ������instance(ʵ�����ı���)
				���д�����ȡ�ö����public����
				ע������ʱ��������ã�����instance+��ȡ�ö���ķ�����Ϊstatic
				��ϰ��TestSingleton.java
			����ʽ
				�����캯�������θ�Ϊprivate
				��������ʵ������instance(ʵ�����ı���)��������
				���д�����ȡ�ö����public�������������ж��������Ƿ񴴽������û�д���һ���µ�ʵ��
				ע������ʱ��������ã�����instance+��ȡ�ö���ķ�����Ϊstatic
				��ϰ��TestSingleton1.java
*/
package day3;

public class TestSingleton1 {

	public static void main(String[] args) {
		Singleton1 s1 = Singleton1.getSingleton();
		Singleton1 s2 = Singleton1.getSingleton();
		System.out.println(s1 == s2);  //�ж����������ǲ���ͬһ��ʵ��

	}
}
// ����ʽ
class Singleton1 {
	private static Singleton1 instance = null;
	// ˽�л��������������ⲻ�ܵ��ã��봴������ֻ���ڸ�����ڲ�������
	private Singleton () {
	}
	// �ṩ�����ķ��������øö���(��Ϊ����ʵ����������ֻ���ø���������static)
	public static Singleton getSingleton() {
		if(instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
