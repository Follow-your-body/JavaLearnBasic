/*
���ģʽ
	����ģʽ
		Ϊ���������ṩһ�ִ����Կ��ƶ��������ķ���
		ͨ���ӿڵķ�ʽ��ͨ������һ����B��ȥ������A�����ֽӿڵĶ�̬�ԣ������ò�ͬ��Ķ�����ʹ�ã�
		��ϰ��TestProxy.java
*/
package day3;

public class TestProxy {

	public static void main(String[] args) {
		ProxyObject p = new ProxyObject();
		p.getAction();
	}

}

interface Object{
	void getAction();
}

// ������
class ProxyObject implements Object {
	Object obj;
	
	public ProxyObject() {
		obj = new ObjectImpl();
		System.out.println("Ϊ�������ഴ���ɹ�");
	}

	@Override
	public void getAction() {
		System.out.println("�������࿪ʼִ��");
		obj.getAction();
		System.out.println("�����������ִ��");
			
	}
	
}

// ��������
class ObjectImpl implements Object {

	@Override
	public void getAction() {
		System.out.println("������ģʽ��ʼ");	
		System.out.println("����Ϊ������ģʽ");				
	}
	
}