/*
 用接口实现多线程：模拟火车站售票窗口，开启三个窗口售票，票数总共为100张
 */

package day14;

public class TestWindow1 {
	public static void main(String[] args) {
		Window1 w1 = new Window1();
		
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w1);
		Thread t3 = new Thread(w1);
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
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
			System.out.println(Thread.currentThread().getName() + "卖完后还剩："+ tickets + "张");
		}
	}
	
}
