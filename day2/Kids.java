/*
	�̳�
		ͨ����class A extends B����ʵ����ļ̳�
		���������������Ի򷽷�ʱ������ͬ�����Ի�ȡ�õ���ֻ�����ڷ�װ�Ե����
		���ǵ����಻����ֱ�ӵ��ð���
		�������ͨ���̳У���ȡ����Ľṹ֮�⣬�����Զ����Լ����еĳɷ֡�
		extends:�����ǶԸ��๦�ܵġ���չ������ȷ���಻�Ǹ�����Ӽ�
		java�ļ̳�ֻ֧�ֵ��̳У�һ����ֻ�ܼ̳�һ�����࣬��֮��һ����������ж������
		����͸�������Եĸ���
		��������д
			���η� ����ֵ���� �������������б�{���ʽ}
			����̳и����������ķ��������಻���ã���ô������ԶԸ���ķ�����д��overWrite��
			����
				���෽���ġ�����ֵ���� �������������б����͸���ķ���һ��
				���෽�������η�����С�ڸ��෽�������η�
				�����෽�����쳣����ô���෽���׵��쳣���ܴ��ڸ���
				�Ӹ���ķ�������ͬΪstatic��ͬΪ��static

 * ������Kids�̳�ManKind��������
��Ա����int yearsOld��
����printAge()��ӡyearsOld��ֵ��
 */
package com.lzw;

public class Kids extends ManKind {  // �̳�ManKind��
	
	private int yearsOld;
	
	public void printAge() {
		System.out.println("yearsOld��ֵΪ�� " + yearsOld);
	}

	public static void main(String[] args) {
		Kids someKid = new Kids();
		someKid.manOrWoman(0);   // ͨ�����󣬵��ø���ķ���
		someKid.employeed(10);
		someKid.salary = 32;   // ͨ�����󣬵��ø���Ĺ�������
		someKid.setSex(0);
		someKid.getSex();  // ͨ�����󣬵��ø����˽������
	}

}
