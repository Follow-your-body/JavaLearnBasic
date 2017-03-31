/*
包装类（Wrapper）
	针对八中基本数据类型定义相应的引用类型——包装类
		int--interger    char--Character
	包装类的使用
		包装类：八中基本数据类型对应着一个类（基本数据类型+包装类+String之间的相互转化）
		练习：包装类+String+基本数据类型之间的相互转换 TestWrapper.java
*/
package day3;
import org.junit.Test;

public class TestWrapper {
	
	// 基本数据类型和包装类之间的转换
	@Test
	public void test1() {
		int i = 90;
		boolean b = false;
		
		// 基本数据类型-->包装类
		Integer i1 = new Integer(i);
		System.out.println(i1.toString());
		Float f1 = new Float("12.34");
		System.out.println(f1);
		// 包装类转基本数据类型
		int i2 = i1.intValue();
		System.out.println(i2);
		float f0 = f1.intValue();
		System.out.println(f0);		
		//JDK5.0之后，自动装箱和拆箱
		int i3 = 145;
		Integer i4 = i3; //自动装箱
		int i5 = i4; //自动拆箱
		
		// 包装类+基本数据类型-->String
		int i6 = 90;
		Integer i7 = new Integer(900);
		String str1 = String.valueOf(i6);
		String str2 = String.valueOf(i7);
		System.out.println(str1 + "\t" + str2);
		// String-->包装类+基本数据类型
		int i8 = Integer.valueOf(str1);
		System.out.println(i8);
		
	}
	

}
