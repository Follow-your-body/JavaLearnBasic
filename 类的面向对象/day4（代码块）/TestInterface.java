/*
�ӿ�(interface)
	��Դ����ʱ����Ӽ���������������һ�����࣬�̳��������е����Ժͷ�����
		����Java ��֧�ֶ��ؼ̳С����˽ӿڣ��Ϳ��Եõ����ؼ̳е�Ч��
	��ɣ����󷽷�+����ֵ����ļ��ϣ���������+һ�㷽��+��������
	ʵ�ֽӿ��ࣺclass ���� implements �ӿ�{}
	�ص㣺һ�������ʵ�ֶ���ӿڣ��ӿ�Ҳ���Լ̳������ӿڣ�extends��
	��ϰ��TestInterface.java
	�ܽ�
		ͨ���ӿڿ���ʵ�ֲ���������ͬ��Ϊ��������Ҫ������Щ��֮��Ĳ�ι�ϵ
		ͨ���ӿڿ���ָ���������Ҫʵ�ֵķ�����һ�����ڶ�������Ź���
		�ӿ���Ҫ��������淶���Ӵ���Ϲ�ϵ
*/
package day3;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AA.I);
//		System.out.println(AA.I = 123);
	}

}

// ���󷽷�+����ֵ����ļ��ϣ���������+һ�㷽��+��������
interface AA{
	//����:���еĳ�������public static final����(һ����ʼ��֮����ֵ�����޸�)
	int I = 12;
	boolean FLAG = false;
	//���󷽷�:���еĶ���public abstract����
	void method1();
	void method2();
//	// ���ܺ��б���+������������ʵ������
//	int i;
//	public AA)(){		
//	}
}

interface MM{
	void method3();
}

//�ӿ�Ҳ���Լ̳������ӿڣ�extends��
interface JJ extends MM,AA{
	void method4();
}

class DD{	
}

// һ�������ʵ�ֶ���ӿ�(��̳�+��ӿ�)
class CC extends DD implements AA,MM{
	public void method1(){		
	}
	public void method2(){		
	}
	public void method3(){		
	}
}