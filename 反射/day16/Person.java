package day16;

@MyAnnotation(value = "�ദ�Զ���ע��1")
public class Person extends Creature<String> implements Comparable, MyInterface{
	public String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@MyAnnotation(value = "�������Զ���ע��1")
	public void show() {
		System.out.println("����һ���ˣ�");
	}
	private void display(String nation) throws Exception{
		System.out.println("�ҵĹ����ǣ� " + nation);
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void info() {
		System.out.println("����һ����̬�ķ�������");
	}
	
	class Brid{
		
	}
	
}
