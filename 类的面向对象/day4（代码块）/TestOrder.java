/*
��ĳ�Ա֮�ģ���ʼ����
	����
		��̬�����
		�Ǿ�̬����飨û��static����
		��ͬ
			������������
			���Զ��������+����������г�ʼ������
			���԰��մ��ϵ��µ�˳������ִ��
		��ͬ
			��̬�����
				�����ԶԷǾ�̬�����ԣ�����+��������ʼ��
				��̬������ִ��Ҫ���ڷǾ�̬�����
				��̬�����ִֻ��һ��
			�Ǿ�̬����飨û��static���Σ�
				ÿһ���������ʱ�򶼻�ִ��һ�Σ������ڹ�����ִ��
		�����Լ��������е����Է���
			�����Source��
				�����ӿ�
				����getter��setter����

				����toString()����
				����hashCode()+equals()����
				���ɹ��캯������
		��ϰ��TestOrder.java
*/
package day3;

public class TestOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order o1= new Order();
		System.out.println(o1);
		Order o2= new Order();
		System.out.println(o2);
	}

}

class Order {
	private int orderId;
	private String orderName;
	private static String orderDesc;
	// �Ǿ�̬��ʼ���飨û�����ƣ�
	{
		orderId = 1002;  // �Ǿ�̬���Գ�ʼ��
		orderName = "a";
		System.out.println("�Ǿ�̬��ʼ����!!"); // ������
		orderDesc = "orderDesc"; // ��̬���Գ�ʼ��
		show1();  // �Ǿ�̬��������
		show2();		
	}
	// ��̬��ʼ����ֻ���������̬����+��̬����+�����䣩
	{
		System.out.println("��̬��ʼ����!!"); // ������
		orderDesc = "orderDesc"; // ��̬���Գ�ʼ��
		show2(); // ��̬������ʼ��
	}
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public Order() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void show1(){
		
	}
	public static void show2(){
		
	}	
	
}
