package com.lzw;

class TestVariable 
{
	public static void main(String[] args) 
	{
		// ������������ʹ��
		int a = 10;
		System.out.println(a);

		// ����
		byte b = 1;
		short s = 3;
		int i = 10;
		long l = 11L;  // long�ͺ�����Լ�L
		// �ָ���
		float f = 1.9f;  // ����һ��Ҫ��F
		double d = 9.0;
		// �ַ���
		char c1 = 'a';
		String str1 = "ab";
		char c2 = '��';
		String str2 = "�й�";
		// ��������
		boolean b1 = true;
		boolean b2 = false;
		
		// �Զ�����ת��
		int i1 = 12;
		float f1 = 13f;
		System.out.println(i1 + f1);
		//�涨��short/byte/char֮�������Ĭ�ϵ�Ϊint����
		short s1 = 123;
		byte b3 = 1;
		System.out.println(s1+b3);		
		
		// ǿ������ת��
		int i2 = 12;
		int i3 = 13;
		System.out.println((float)i2+i3);
		
		// ����ת������
		String str3 = 3.5f + "";
		System.out.println(str3);
		System.out.println(3 + 4 + "Hello!" + 3 + 4);
		System.out.println('a' + 4 + "Hello!" + 'a' + 1);		
	}
}