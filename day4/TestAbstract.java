/*
������
	���壺��һ��������Ƶķǳ�����������û�о����ʵ���������������������
	abstract�����ࣺ������
		����ʵ����
		�������й��������ϻ���
		���󷽷����ڵ���һ���ǳ�����
		�������п���û�г��󷽷�
	abstract���η��������󷽷�
		��ʽ��û�з����壬����{}����breath����
		ֻ�ܱ��������Ĺ��ܣ��������ִ�У������̳��������
			����������д�˳��󷽷�
		������̳г����࣬����д���еĳ��󷽷����������һ��ʵ���࣬
			�ȿ���ʵ��������Student��
		������̳г����࣬û����д���еĳ��󷽷�����ζ�Ŵ��������г��󷽷�
			��������������Ϊ�����࣬��Person��
	abstract ���������������ԡ���������private��final��static
	��ϰ��TestAbstract.java
*/
package day3;

public class TestAbstract {

	public static void main(String[] args) {
//		// Cannot instantiate the type Creator(�����಻��ʵ����)
//		Creator c = new Creator();
		Student s = new Student();
		s.breath("ѧ��", "����");
		s.walk("ѧ��", "������·");
		s.eat("ѧ��", "���+ţ��");
		Worker w = new Worker();
		w.breath("����", "��֪��");
		s.walk("����", "��֪��");
		w.eat("����", "��֪��");
	}

}

// ���󷽷����ڵ���һ���ǳ�����(The type Creator must be an abstract class to define abstract methods)
abstract class Creator {
	abstract void breath(String name, String meathod);	
}

abstract class Person extends Creator{
//	// only public, protected, private, static, final,transient & volatile are permitted
//	abstract int personId;
	private String name;
	abstract void walk(String name, String meathod);
	abstract void eat(String name, String food);
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

class Student extends Person{
	void walk(String name, String meathod) {
		System.out.println(name + "��·�ķ�ʽΪ" + meathod + "!!");
	}
	void eat(String name, String food) {
		System.out.println(name + "�Ե�ʳ����" + food + "!!");
	}
	// 
	@Override
	void breath(String name, String meathod) {
		System.out.println(name + "��" + meathod + "��������");		
	}	
}

class Worker extends Person{
	void walk(String name, String meathod) {
		System.out.println("���ϵĶ���·��ʽ��֪����");
	}
	void eat(String name, String food) {
		System.out.println("���˳Ե�ʳ��Ҳ��֪����");
	}
	@Override
	void breath(String name, String meathod) {
		System.out.println("���˵ĺ�����ʽҲ��֪����");		
	}	
}