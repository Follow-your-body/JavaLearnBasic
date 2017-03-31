/*
	处理异常（抓抛模型）
		抛异常
			当我们执行代码时，一旦出现异常，就会在异常的代码处生成一个对应的异常类型的队形
				，并对此对象抛出
			>一旦抛出此异常类的对象，那么程序就终止执行
			>此异常类的对象抛给调用者
		抓异常
			抓住上一步抛出来的类的对象，如何抓即为异常处理方式
			Java提供了两种用来处理一个异常类的对象
				方式一
					try{
					//可能出现异常的代码
					}catch(Exception e) {
					// 对异常的处理方式
					}finally {
					// 无论有没有有异常都执行
					}
				注
					try内声明的变量，类似于局部变量，除了try{}语句，就不能被调用
					finally为可选项
					catch内部是对异常类的处理（可以有多个）
					如果异常处理了，那么异常代码继续执行
				练习  TestException.java
*/
package day5;
import java.util.Date;

public class TestException {

	public static void main(String[] args) {
		// 数组下标异常（ArrayIndexOutOfBoundsException）
		try {
			String[] str = new String[9];
			System.out.println(str[-9]);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 算数异常（ArithmeticException）
		try {
			int i1 = 3;
			System.out.println(i1 / 0);			
		}catch(Exception e) {
			e.printStackTrace();
		}		

		// 类型转换异常（ClassCastException）
		try {
			Object obj = new Date();
			String str = (String)obj;
		}catch(Exception e) {
			e.printStackTrace();
		}

		// 空指针异常（NullPointerException）
		try {
			Person p = new Person();
			p = null;  // 将对象的初始化清空
			System.out.println(p.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}