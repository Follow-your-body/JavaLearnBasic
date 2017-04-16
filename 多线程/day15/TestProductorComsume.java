/*
 ��Ŀ
	 �����ߣ�Productor������Ʒ������Ա��Clerk�����������ߣ�Customer���ӵ�Ա��ȡ�߲�Ʒ��
	��Աһ��ֻ�ܳ��й̶������Ĳ�Ʒ�����磺20���������������ͼ��������Ĳ�Ʒ����Ա��
	��������ͣһ�£���������п�λ�Ų�Ʒ����֪ͨ�����߼����������������û�в�Ʒ�ˣ�
	��Ա����������ߵ�һ�£���������в�Ʒ����֪ͨ��������ȡ�߲�Ʒ��
����
	�ǲ����ж��̣߳�
		�У�������+������+��Ա
	��û�й������ݣ�
		�У���Ա����Ʒ������--����Ա������Ϊ�߳�
		�������ݶ���ʲô����Ʒ�Ӽ�
	�Ƿ����߳�ͨ�ţ�
		�У���Ա֪ͨ������ͣ��+֪ͨ������û�в�Ʒ�ȴ�
		-->��������������Ҫ����֪ͨ
 */
package day15;


class Clerk { // ��Ա
	static int product = 0;
	
	public synchronized void addProduct() {
		while(true) {
			if(product < 20) {
				notify();
				product++;
				System.out.println(Thread.currentThread().getName() + "�����˵�" + product + "����Ʒ��");
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
				System.out.println(Thread.currentThread().getName() + "�����˵�" + product + "����Ʒ��");
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

class Customer implements Runnable { // ������
	Clerk clerk;
	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}
	
	public void run() {
		clerk.consumeProduct();
	}
}


class Productor implements Runnable{ // ������
	
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
		
		t1.setName("������");
		t2.setName("������");
		
		t1.start();
		t2.start();		
	}
}
