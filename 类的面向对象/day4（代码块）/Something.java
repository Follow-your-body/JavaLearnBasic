/*
final�ؼ���
	final��ǵ��಻�ܱ��̳�
	final��ǵķ������ܱ�������д
	final��������Ա����+�ֲ�����������Ϊ���������ƴ�д����ֻ�ܱ���ֵһ��
		�˳��������︳ֵ���ٴ˳�������ʹ��Ĭ�ϳ�ʼ�� �ڿ�����ʽ�ĸ�ֵ������顢��������
	��ϰ��TestFinal.java  Something.java
*/
package day3;

public class Something {
	public static void main(String[] args) {
		Other o = new Other();
		Something s = new Something();
//		s.addOne(12);
		new Something().addOne(o);
	}

	public void addOne(final Other o) {
		//o = null;
		System.out.println(o.i++);
	}

//	 public int addOne(final int x) {
//		 // The final local variable x cannot be assigned.
//		 return ++x;
//	 }
}

class Other {
	public int i;
}
