/*
super�ؼ���
		�����ڷ��ʸ����е�����+��Ա������ͬ��ʱ�������������֣�
		�����������๹�췽���е��ø���Ĺ�����
		������ռ�ı�ʶ
		1��������͸�������ͬ��������ʱ������ͨ����supper�������ԡ���ʽ�ĵ��ø���������������
		������õ���������ͬ�������ԡ�this.�����ԡ�
		2����������д����ķ����Ժ�����������������ʽ�ĵ��ø���ı���д�ķ���������Ҫʹ��
		��super.��������
		3��super���ι�������ͨ����������ʹ�á�super���β��б�������ʽ�ĵ��ø�����ָ���Ĺ�����
			�ڹ������ڲ�����super���β��б�����������������
			�ڹ������ڲ�����this(�β��б�)����super(�β��б�)��ֻ�ܳ���һ��
			�ڹ������ڲ�������ʽ�ĵ��á�this(�β��б�)����super(�β��б�)�������κ�һ����Ĭ�ϵ��õ�ʱ����ղεĹ�����
			���飺��ù���һ���ղεĹ�����
*/
package com.lzw;

public class CheckAccount extends Account{
	
	private int overdraft;
	
	public CheckAccount(int id, double balance, double annualInterestRate, int overdraft) {  // ���������Լ��Ĺ��캯��
		super(id, balance, annualInterestRate);   // �̳и��๹�캯��
		this.overdraft = overdraft;
	}
	
	public void withdraw(double amount) {
		if(super.getBalance() < amount) {  //���ø���ķ�����super.����
			System.out.println("���㣡");
		}else {
			super.setBalance((super.getBalance() - amount));
		}
	}

	public static void main(String[] args){
		CheckAccount ca = new CheckAccount(1122, 20000, 0.045, 5000);
		ca.withdraw(5000);
		System.out.println("�˻����Ϊ��" + ca.getBalance() + "��͸֧���Ϊ�� "+ ca.overdraft);
		ca.withdraw(3000);
		System.out.println("�˻����Ϊ��" + ca.getBalance() + "��͸֧���Ϊ�� "+ ca.overdraft);
	}
}
