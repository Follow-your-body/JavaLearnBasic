/*
final�ؼ���
	final��ǵ��಻�ܱ��̳�
	final��ǵķ������ܱ�������д
	final��������Ա����+�ֲ�����������Ϊ���������ƴ�д����ֻ�ܱ���ֵһ��
		�˳��������︳ֵ���ٴ˳�������ʹ��Ĭ�ϳ�ʼ�� �ڿ�����ʽ�ĸ�ֵ������顢��������
	��ϰ��TestFinal.java
*/
package day3;

public class TestFinal {

	public static void main(String[] args) {
	}

}

class A1{
	final int i1 = 90;
	final double PI;
	final String NAME;
	// ������г�ʼ��final����
	{
		PI = 3.14;
	}	
	// �������г�ʼ��final������final����ֻ�ܱ���ֵһ�Σ�
	public A1(double pI, String nAME) {
		super();
//		// The final field PI may already have been assigned
//		PI = pI;
		NAME = nAME;
	}


	final public void a1() {		
	}
	
}
//class B1 extends A1 {
//	/*
//	�����в����޸ĸ����final���εķ���
//	 Multiple markers at this line
//	- overrides day3.A1.a1
//	- Cannot override the final method 
//	*/ 
//	public void a1() {
//		
//	}
//}

final class A{	
}
//// he type B cannot subclass the final class A
//class B extends A{
//	
//}