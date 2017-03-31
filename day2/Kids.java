/*
	继承
		通过“class A extends B”类实现类的继承
		当父类中似有属性或方法时，子类同样可以获取得到，只是由于封装性的设计
		，是的子类不可以直接调用罢了
		子类除了通过继承，获取父类的结构之外，还可以定义自己特有的成分。
		extends:子类是对父类功能的“扩展”，明确子类不是父类的子集
		java的继承只支持单继承，一个类只能继承一个父类，反之，一个父类可以有多个子类
		子类和父类是相对的概念
		方法的重写
			修饰符 返回值类型 方法名（参数列表）{表达式}
			子类继承父类后，若父类的方法对子类不适用，那么子类可以对父类的方法重写（overWrite）
			规则
				子类方法的“返回值类型 方法名（参数列表）”和父类的方法一样
				子类方法的修饰符不能小于父类方法的修饰符
				若父类方法抛异常，那么子类方法抛的异常不能大于父类
				子父类的方法必须同为static或同为非static

 * 定义类Kids继承ManKind，并包括
成员变量int yearsOld；
方法printAge()打印yearsOld的值。
 */
package com.lzw;

public class Kids extends ManKind {  // 继承ManKind类
	
	private int yearsOld;
	
	public void printAge() {
		System.out.println("yearsOld的值为： " + yearsOld);
	}

	public static void main(String[] args) {
		Kids someKid = new Kids();
		someKid.manOrWoman(0);   // 通过对象，调用父类的方法
		someKid.employeed(10);
		someKid.salary = 32;   // 通过对象，调用父类的公有属性
		someKid.setSex(0);
		someKid.getSex();  // 通过对象，调用父类的私有属性
	}

}
