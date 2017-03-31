/*接口的应用
 接口（连接day4）
	接口可以实例化继承了它的可以实例化的类（没有继承他的+本身的接口，不可以实例化成该接口的对象）
	接口的匿名类对象
		方法一：直接创建一个接口类对象，调用接口的构造器（虽然接口没有构造器，现在覆盖抽象方法就可以），
		方法二：匿名的对象作为方法的形参传入方法，在方法内需要将该接口的抽象方法全部重写
			，重写之后运行就可以运行成功
		练习：TestUsb.java
 */
 package day5;

public class TestUsb {

	public static void main(String[] args) {
		Computer c = new Computer();
		c.doWork(new Printer());
		
		Flash f = new Flash();
		c.doWork(f);
		
		// 实现接口的匿名类的对象方法1
		//（但是接口没有构造器：即USB phone = new USB();是不对的）
		// 对象不知道是哪个类的，所以用接口的名称顶一下
		USB phone = new USB() {
			@Override
			public void UsbStart() {
				System.out.println("手机开始工作");		
			}

			@Override
			public void UsbStop() {
				System.out.println("手机结束工作");		
			}
			
		};
		c.doWork(phone);
		
		// 实现接口的匿名类的对象方法2(对象不知道是哪个类的，所以用接口的名称顶一下)
		c.doWork(new USB() {
			@Override
			public void UsbStart() {
				System.out.println("手机开始工作");		
			}

			@Override
			public void UsbStop() {
				System.out.println("手机结束工作");		
			}
		});
		
		
//		// Type mismatch: cannot convert from Computer to USB
//		USB usb1 = new Computer();
//		// 接口可以实例化继承了它的可以实例化的类（没有继承他的+本身的接口，不可以实例化成该接口的对象）
//		USB usb2 = new Printer();

	}

}

interface USB {
	// 定义尺寸（public static final）
	int HEIGHT = 30;
	int WIEDTH = 40;
	
	// 定义功能（抽象方法）
	void UsbStart();
	void UsbStop();
}

class Printer implements USB {

	@Override
	public void UsbStart() {
		System.out.println("打印机开始工作");		
	}

	@Override
	public void UsbStop() {
		System.out.println("打印机结束工作");		
	}
	
}

class Flash implements USB {

	@Override
	public void UsbStart() {
		System.out.println("U盘开始工作");		
	}

	@Override
	public void UsbStop() {
		System.out.println("U盘结束工作");	
	}
	
}

class Computer {
	
	void doWork(USB usb) {
		usb.UsbStart();
		System.out.println("    设备开始连接……");	
		usb.UsbStop();
	}
}
