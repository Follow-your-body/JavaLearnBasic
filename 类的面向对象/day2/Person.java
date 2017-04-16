/*
面向对象
	与面向过程的区别
		对象中加有封装+继承+多态
		把大象塞进冰箱
		过程：开门+把大象塞进冰箱+关门
		面向对象：对 象（人（打开冰箱+操作大象+关闭门）+大象（进入冰箱）+冰箱（开开+关闭门））
	类和类之间的关系
		关联关系（人+事物，人和食物有关系）
		继承关系（运动员-篮球运动员+足球运动员+棒球运动员）
		聚集关系（球队-队长+队员）
		组合（人-手+胳膊+腿）
	用途
		完成需求
		具有该所需的对象+如果不存在自己创建
	类中的含有
		属性：类的成员变量（field）
		行为：类的成员方法(methiod)

	落地法则
		设计类，并设计类的成员（成员变量&成员方法）
		通过类来创建类的对象（类的实例化）
		通过“对象.属相”或“对象.方法”来调用，完成相应的功能
		特点
			创建多个对象，彼此各自拥有一套类的属性，当对其中一个对象的属性进行修改时，不会影响到其他对象的属性值
			成员变量VS局部变量
				同
					遵循变量声明的格式：数据类型 变量名 [=初始值]
					都有对应的作用域
				不同
					声明的位置不同
						成员变量：类里+方法外
						局部变量：方法内，形参部分在代码块
					成员变量有修饰符
		类的方法：提供某种功能的实现
			实例格式： 权限修饰符 返回值类型 方法名（形参属性 形参名） {表达式}
				返回值类型：void：此方法不需要返回值
					有返回值的方法，在方法后的最后一定有return+返回值类型的对应变量
 * 创建一个Person类
 * 属性有：name+age+sex
 * 方法有：
 * 		study() void，用来输出：studying字符串
 * 		showAge() void:用来输出年龄
 * 		addAge(int i) int :用来给年龄加i
 * 		circleArea(int r) void : 用来计算圆的面积，并输出{}岁的{}来计算半径为{}的面积为{}
 * 创建两个对象，分别对属性赋值，分别调用类中所有的方法
 */
package com.lzw;

public class Person {
	private String name;
	private int age;
	private int sex;
	
	public static void study() {
		System.out.println("studying");
	}
	
	public void showAge() {
		System.out.println(age);
	}
	
	public int addAge(int i) {
		return age += i;	
	}
	
	public void circleArea(int r) {
		System.out.println(age + "岁的" + name + "来计算半径为" + r + "的圆的面积为：" + (float)Math.PI * r * r);
	}
	

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 12;
		p1.name = "danay";
		p1.sex = 1;
		p1.study();
		p1.addAge(2);
		p1.circleArea(2);
		
		Person p2 = new Person();
		p2.age = 13;
		p2.name = "anna";
		p2.sex = 0;
		p2.study();
		p2.addAge(2);
		p2.circleArea(4);
	}

}
