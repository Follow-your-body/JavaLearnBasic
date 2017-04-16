package day16;

@MyAnnotation(value = "类处自定义注解1")
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
	@MyAnnotation(value = "方法处自定义注解1")
	public void show() {
		System.out.println("我是一个人：");
	}
	private void display(String nation) throws Exception{
		System.out.println("我的国籍是： " + nation);
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void info() {
		System.out.println("这是一个静态的方法！！");
	}
	
	class Brid{
		
	}
	
}
