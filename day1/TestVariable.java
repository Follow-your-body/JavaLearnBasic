package com.lzw;

class TestVariable 
{
	public static void main(String[] args) 
	{
		// 必须先声明后使用
		int a = 10;
		System.out.println(a);

		// 整型
		byte b = 1;
		short s = 3;
		int i = 10;
		long l = 11L;  // long型后面可以加L
		// 字浮型
		float f = 1.9f;  // 后面一定要加F
		double d = 9.0;
		// 字符型
		char c1 = 'a';
		String str1 = "ab";
		char c2 = '中';
		String str2 = "中国";
		// 布尔类型
		boolean b1 = true;
		boolean b2 = false;
		
		// 自动类型转换
		int i1 = 12;
		float f1 = 13f;
		System.out.println(i1 + f1);
		//规定：short/byte/char之间的运算默认的为int类型
		short s1 = 123;
		byte b3 = 1;
		System.out.println(s1+b3);		
		
		// 强制类型转换
		int i2 = 12;
		int i3 = 13;
		System.out.println((float)i2+i3);
		
		// 进制转换案例
		String str3 = 3.5f + "";
		System.out.println(str3);
		System.out.println(3 + 4 + "Hello!" + 3 + 4);
		System.out.println('a' + 4 + "Hello!" + 'a' + 1);		
	}
}
