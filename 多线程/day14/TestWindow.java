/*
 ģ���վ��Ʊ���ڣ���������������Ʊ��Ʊ���ܹ�Ϊ100��
 */
package day14;

public class TestWindow {
	public static void main(String[] args) {
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();
		
		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");
		
		w1.start();
		w2.start();
		w3.start();		
	}

}

class Window extends Thread{
	private static int tickets = 100;
	int sum = 0;
	
	public void run() {
		while(tickets != 0) {
			tickets -= 1; 
			sum += 1;
			System.out.println(Thread.currentThread().getName() + "�����ʣ��"+ tickets + "��");
		}
		System.out.println(Thread.currentThread().getName() + "Ʊ�����꣡ �������һ������" + sum + "��Ʊ��");
	}
	
}
