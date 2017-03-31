/*
���ģʽ
		��������
			����һ�����ڴ�������Ľӿڣ����������ʵ������һ����
				��FactoryMethodʹһ�����ʵ�����ӳٵ�������
			������
				��һ���಻֪�������봴���Ķ�������ʱ��
				��һ����ϣ��������������ָ�����������Ķ����ʱ��
				���ཫ���������ְ��ί�и�������������е�ĳһ����������ϣ��
					����һ�����������Ǵ�������һ��Ϣ�ֲ�����ʱ��
			��ϰ��TestFactoryMethod.java
*/
package day3;

public class TestFactoryMethod {

	public static void main(String[] args) {
		// ��̬�ԣ�ʵ�����Ķ����Ӧ���಻ͬ��
		IWorkFactory i1 = new StudentFactory();
		i1.getWork().doWork();
		IWorkFactory i2 = new TeacherFactory();
		i2.getWork().doWork();
	}

}

// �򵥵Ľ�ڣ����󻭷���--�������ݣ�
interface Work {
	void doWork();
}

class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("ѧ������д��ҵ+����");		
	}
	
}

class TeacherWork implements Work {

	@Override
	public void doWork() {
		System.out.println("��ʦ�������ҵ+����");		
	}
	
}

// ��ȡ��Ӧ�Ķ�����Ķ��󣬷��ص�ʱΪʲô��Work������е㲻̫���ף�������
interface IWorkFactory {
	Work getWork();
}

class StudentFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		// TODO Auto-generated method stub
		return new StudentWork();
	}
	
}

class TeacherFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		// TODO Auto-generated method stub
		return new TeacherWork();
	}
	
}