/*
��װ�ࣨWrapper��
	��԰��л����������Ͷ�����Ӧ���������͡�����װ��
		int--interger    char--Character
	��װ���ʹ��
		��װ�ࣺ���л����������Ͷ�Ӧ��һ���ࣨ������������+��װ��+String֮����໥ת����
		��ϰ����װ��+String+������������֮����໥ת�� TestWrapper.java
*/
package day3;
import org.junit.Test;

public class TestWrapper {
	
	// �����������ͺͰ�װ��֮���ת��
	@Test
	public void test1() {
		int i = 90;
		boolean b = false;
		
		// ������������-->��װ��
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		Float f1 = new Float("12.34");
		System.out.println(f1);
		// ��װ��ת������������
		int i2 = i1.intValue();
		System.out.println(i2);
		float f0 = f1.intValue();
		System.out.println(f0);		
		//JDK5.0֮���Զ�װ��Ͳ���
		int i3 = 145;
		Integer i4 = i3; //�Զ�װ��
		int i5 = i4; //�Զ�����
		
		// ��װ��+������������-->String
		int i6 = 90;
		Integer i7 = new Integer(900);
		String str1 = String.valueOf(i6);
		String str2 = String.valueOf(i7);
		System.out.println(str1 + "\t" + str2);
		// String-->��װ��+������������
		int i8 = Integer.valueOf(str1);
		System.out.println(i8);
		
	}
	

}
