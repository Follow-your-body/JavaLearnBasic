/*
	�����쳣��ץ��ģ�ͣ�
		���쳣
			������ִ�д���ʱ��һ�������쳣���ͻ����쳣�Ĵ��봦����һ����Ӧ���쳣���͵Ķ���
				�����Դ˶����׳�
			>һ���׳����쳣��Ķ�����ô�������ִֹ��
			>���쳣��Ķ����׸�������
		ץ�쳣
			ץס��һ���׳�������Ķ������ץ��Ϊ�쳣����ʽ
			Java�ṩ��������������һ���쳣��Ķ���
				��ʽһ
					try{
					//���ܳ����쳣�Ĵ���
					}catch(Exception e) {
					// ���쳣�Ĵ���ʽ
					}finally {
					// ������û�����쳣��ִ��
					}
				ע
					try�������ı����������ھֲ�����������try{}��䣬�Ͳ��ܱ�����
					finallyΪ��ѡ��
					catch�ڲ��Ƕ��쳣��Ĵ��������ж����
					����쳣�����ˣ���ô�쳣�������ִ��
				��ϰ  TestException.java
*/
package day5;
import java.util.Date;

public class TestException {

	public static void main(String[] args) {
		// �����±��쳣��ArrayIndexOutOfBoundsException��
		try {
			String[] str = new String[9];
			System.out.println(str[-9]);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// �����쳣��ArithmeticException��
		try {
			int i1 = 3;
			System.out.println(i1 / 0);			
		}catch(Exception e) {
			e.printStackTrace();
		}		

		// ����ת���쳣��ClassCastException��
		try {
			Object obj = new Date();
			String str = (String)obj;
		}catch(Exception e) {
			e.printStackTrace();
		}

		// ��ָ���쳣��NullPointerException��
		try {
			Person p = new Person();
			p = null;  // ������ĳ�ʼ�����
			System.out.println(p.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}