/*�ӿڵ�Ӧ��
 �ӿڣ�����day4��
	�ӿڿ���ʵ�����̳������Ŀ���ʵ�������ࣨû�м̳�����+����Ľӿڣ�������ʵ�����ɸýӿڵĶ���
	�ӿڵ����������
		����һ��ֱ�Ӵ���һ���ӿ�����󣬵��ýӿڵĹ���������Ȼ�ӿ�û�й����������ڸ��ǳ��󷽷��Ϳ��ԣ���
		�������������Ķ�����Ϊ�������βδ��뷽�����ڷ�������Ҫ���ýӿڵĳ��󷽷�ȫ����д
			����д֮�����оͿ������гɹ�
		��ϰ��TestUsb.java
 */
 package day5;

public class TestUsb {

	public static void main(String[] args) {
		Computer c = new Computer();
		c.doWork(new Printer());
		
		Flash f = new Flash();
		c.doWork(f);
		
		// ʵ�ֽӿڵ�������Ķ��󷽷�1
		//�����ǽӿ�û�й���������USB phone = new USB();�ǲ��Եģ�
		// ����֪�����ĸ���ģ������ýӿڵ����ƶ�һ��
		USB phone = new USB() {
			@Override
			public void UsbStart() {
				System.out.println("�ֻ���ʼ����");		
			}

			@Override
			public void UsbStop() {
				System.out.println("�ֻ���������");		
			}
			
		};
		c.doWork(phone);
		
		// ʵ�ֽӿڵ�������Ķ��󷽷�2(����֪�����ĸ���ģ������ýӿڵ����ƶ�һ��)
		c.doWork(new USB() {
			@Override
			public void UsbStart() {
				System.out.println("�ֻ���ʼ����");		
			}

			@Override
			public void UsbStop() {
				System.out.println("�ֻ���������");		
			}
		});
		
		
//		// Type mismatch: cannot convert from Computer to USB
//		USB usb1 = new Computer();
//		// �ӿڿ���ʵ�����̳������Ŀ���ʵ�������ࣨû�м̳�����+����Ľӿڣ�������ʵ�����ɸýӿڵĶ���
//		USB usb2 = new Printer();

	}

}

interface USB {
	// ����ߴ磨public static final��
	int HEIGHT = 30;
	int WIEDTH = 40;
	
	// ���幦�ܣ����󷽷���
	void UsbStart();
	void UsbStop();
}

class Printer implements USB {

	@Override
	public void UsbStart() {
		System.out.println("��ӡ����ʼ����");		
	}

	@Override
	public void UsbStop() {
		System.out.println("��ӡ����������");		
	}
	
}

class Flash implements USB {

	@Override
	public void UsbStart() {
		System.out.println("U�̿�ʼ����");		
	}

	@Override
	public void UsbStop() {
		System.out.println("U�̽�������");	
	}
	
}

class Computer {
	
	void doWork(USB usb) {
		usb.UsbStart();
		System.out.println("    �豸��ʼ���ӡ���");	
		usb.UsbStop();
	}
}
