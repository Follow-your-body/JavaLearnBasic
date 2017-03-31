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

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s1 == s2);  //�ж����������ǲ���ͬһ��ʵ��

	}
}

class Singleton {
	private static Singleton instance = new Singleton();
	// ˽�л��������������ⲻ�ܵ��ã��봴������ֻ���ڸ�����ڲ�������
	private Singleton () {
	}
	// �ṩ�����ķ��������øö���(��Ϊ����ʵ����������ֻ���ø���������static)
	public static Singleton getSingleton() {
		return instance;
	}
}
