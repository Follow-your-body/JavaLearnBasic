/*
 题目
	 生产者（Productor）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品，
	店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员会
	叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
	店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
分析
	是不是有多线程？
		有，生产者+消费者+店员
	有没有共享数据？
		有：店员（产品数量）--》店员不能作为线程
		共享数据都干什么：产品加减
	是否有线程通信？
		有，店员通知生产者停产+通知消费者没有产品等待
		-->共享数据类中需要加有通知
 */
package day15;


class Clerk { // 店员
	static int product = 0;
	
	public synchronized void addProduct() {
		while(true) {
			if(product < 20) {
				notify();
				product++;
				System.out.println(Thread.currentThread().getName() + "生产了第" + product + "件产品。");
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void consumeProduct() {
		while(true) {
			if(product > 0) {
				notify();
				System.out.println(Thread.currentThread().getName() + "消费了第" + product + "件产品。");
				product--;
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Customer implements Runnable { // 消费者
	Clerk clerk;
	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		clerk.consumeProduct();
	}
}


class Productor implements Runnable{ // 生产者
	
	Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		clerk.addProduct();
	}
}


public class TestProductorComsume {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Customer c = new Customer(clerk);
		Productor p = new Productor(clerk);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		
		t1.setName("消费者");
		t2.setName("生产者");
		
		t1.start();
		t2.start();		
	}
}
