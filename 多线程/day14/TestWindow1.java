/*
 �ýӿ�ʵ�ֶ��̣߳�ģ���վ��Ʊ���ڣ���������������Ʊ��Ʊ���ܹ�Ϊ100��
 */

package day14;

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w1 = new Window1();
		
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w1);
		Thread t3 = new Thread(w1);
		
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		
		t1.start();
		t2.start();
		t3.start();	
	}
}

class Window1 implements Runnable{
	private int tickets = 100;
	int sum = 0;
	
	public void run() {
		while(tickets != 0) {
			tickets -= 1; 
			sum += 1;
			System.out.println(Thread.currentThread().getName() + "�����ʣ��"+ tickets + "��");
		}
	}
	
}
