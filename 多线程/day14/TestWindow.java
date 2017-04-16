/*
 模拟火车站售票窗口，开启三个窗口售票，票数总共为100张
 */
package day14;

public class TestWindow {
	public static void main(String[] args) {
		Window w1 = new Window();
		Window w2 = new Window();
		Window w3 = new Window();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
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
			System.out.println(Thread.currentThread().getName() + "卖完后还剩："+ tickets + "张");
		}
		System.out.println(Thread.currentThread().getName() + "票已售完！ 这个窗口一共卖了" + sum + "张票！");
	}
	
}
