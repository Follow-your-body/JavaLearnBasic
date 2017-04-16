/**
 * ��Ŀ
 * �����Ƕ���Ŀ������в���
 * 
 * ����
 * 1.readTextFile(String filename)
 * 2.���캯��
 * 
 * 
 * */
package Exam9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemService {
	Item[] items;
	
	/**
	 * �вι�����
	 * һ��ItemService���󡪡�10��Item����
	 * this�ж�ȡreadTextFile��filename���ļ����ݸ�ֵ��List<String> list
	 * Ȼ��list�е���Ϣ��Ӧ��ֵ��Item���������
	 * */
	public ItemService() {
		items = new Item[10];    //TODO Item�������Ҳ�������ɳ�Ա��������ʽ
		String filename = "E:\\Users\\danay\\workspace\\Exam\\Items.txt";     //TODO �Ӵ�����ظ���������filename�������ɳ�Ա��������ʽ
		List<String> list = this.readTextFile(filename);
		for(int i = 0; i < 10; i++) {
			Item item = new Item(list.get(7 * i), list.get(7 * i + 1), list.get(7 * i + 2),
					list.get(7 * i + 3), list.get(7 * i + 4), list.get(7 * i + 5));
			items[i] = item;
		}
	}
	
	
	/**
	 * ��ȡ����
	 * */
	public Item getItem(int no) {   //TODO ���������ΧӦ����ô�죿��
		return items[no];
	}
	

	/**
	 * �÷����ɶ�ȡ����ָ�����ı��ļ����� ����ʹ�ð�װ��������ӡ�������Ļ�ϡ�
	 * @param filename
	 * */
	private List<String> readTextFile(String filename){
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File(filename));   //TODO ����ֱ��д���־ͺã�����new��
			br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) {  //TODO ����û��ȥ�����У�������Ķ�ȡ����һ������
				list.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * �÷�������answer.dat�������ļ������������е������Զ�����ʽд�뵽�ļ��б��档
	 * ��ʾ��ʹ�ö������л�����
	 * */
	public void saveAnswer(char[] answer) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("answer.dat"));
			oos = new ObjectOutputStream(fos);
			for(int i = 0; i < answer.length; i++) {     //TODO ����д��ʱ����һͬд�룬����oos.writeObject(answer);
				oos.writeObject(answer[i]);
			}
		} catch (FileNotFoundException e) {    //TODO �쳣��һ���Ϳ�����
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
