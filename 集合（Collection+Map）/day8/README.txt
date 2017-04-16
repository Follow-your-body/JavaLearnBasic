毕设名称：智能鞋盒信息识别功能设计与开发
功能：按键拍照，于此同时将信息写入IC卡中，IC通过RFID RC522写卡
	，将信息图片信息识别出来显示在0.9寸的LCD显示屏上
现在的功能
	将信息手动写入IC卡中，然后读取IC信息，将此信息现实到LCD显示屏上
硬件
	RFID RC522
	LCD 12864
	IC
	MSP430G2553
硬件管脚设计
	RFID（SPI通信）
		SDA：p1.3
		SCK：p1.4
		MOSI：p1.5
		MISO：p2.0
		IRQ：不接
		GND
		RST：p2.1
		VCC：3.3V
	LCD 12864（SPI通信）
		GND
		VCC：3.3V
		SCL：时钟,p2.2
		SDA：数据,p1.2
		RST：复位,p1.1
		D/C：选,p1.0
	p2.3
		0:写卡
		1：读卡
软件程序工程文件说明
	qumo.h
		常用ASCII表取模显式
		“BITFT”中logo的取模
		128X64I液晶底层驱动[8X16]字体库
	12864.h
		LCD属性值声明
		管脚声明+定义
		LCD使用函数声明
	12864.c
		函数定义
	Key_Proccess.h
		声明按键函数
			该函数主要是判断p2.3管脚的电平，将获取的信息赋值给oprationcard变量
	Key_Proccess.c
		定义按键函数
	Key.h
		声明获取按键（p2.3）函数
	Key.c
		定义获取按键（p2.3）函数,如果按下Ret=1，反之Ret=0；
	LED.h
		初始化p1.6（灭）灯的初始化状态
		声明设备连接函数
		声明设备工作函数
	LED.c
		定义设备连接函数
			如果设备连接正常，p1.6这个灯就会亮
		定义设备工作函数
			如果设备连接，可以正常工作，p1.6这个灯就会闪亮
	SPI.h
		定义RFID RC522管脚
		声明SPI的方法
	SPI.c
		定义SPI在SPI.h中声明的方法
	System.h
		将该工程用到的所有.h文件作成自定义库来调用
	Timer.h
		声明timeA的方法
		创建Timer0_Init对应的计数变量
	Timer.c
		定义timeA的方法
		定义timeA的中断函数
	rc522.h
		初始化MF522命令字
		初始化Mifare_One卡片命令字
		初始化MF522 FIFO长度定义
		初始化MF522寄存器定义和MF522通讯时返回的错误代码
		声明RC522对应的方法
	rc522.c
		定义在rc522.h声明的方法
	ReadOrWhriteCard.c
		本来想将这个放在rc522.c中，但是rc522.c代码有点长，所以分开来写
		定名寻卡，读写卡的函数

2.4LCD管脚定义
	GND
	VCC:3.3V
	CLK：p1.4
	MOSI：p1.2
	RES：p1.5
	DC：p1.0
	BLK：不接
	MISO：p1.1
OV7670定义管脚
	VCC		3.3V	
	SIOC		SCCB接口的控制时钟（部分单片机需要上位控制，和I2C接口类似）	
	VSYNC		帧同步信号（输出信息）
	D7		输出信号
	D5		输出信号
	D3		输出信号
	D1		输出信号
	REST		复位端口（正常使用拉高）
	STROBE		拍照闪光灯控制端口（可不用）
	FIFOWR		FIFO写控制端（1：允许CMOS写入FIFO）
	FIFOWRST	FIFO写指针复位端	

	GND		GND
	SIOD		SCCB接口的串行数据输入、出端（部分单片机需要上位控制，和I2C接口类似）
	HREF		行同步信号（输出信号，一般可以不适用，特殊情况使用）
	D6		输出信号
	D4		输出信号
	D2		输出信号
	D0		输出信号
	PWDN		功耗选择模式（正常使用拉低）
	FIFORCK	FIFO	内存读取时钟控制端
	FIFOOEFIFO	关断控制
	FIFOREST	FIFO读指针复位端

遇到的错误
	Description	Resource	Path	Location	Type
#10010 errors encountered during linking; "MSP430G2553Practice.out" not built	MSP430G2553Practice		 	C/C++ Problem


OV7670使用之前的资料了解
	OV7679接口时序
		SCCB接口时序
			SCCB是欧姆龙公司开发的一种总线，用在OV系列图像传感器上，
			由三种总线组成：SCCC_E+SIO_C+SIO_D,使用时只有SIO_C+SIO_D两根线
			起始和终止时序
			SIO_D：tPRA和tPRC决定


			
		图像数据输出时序
