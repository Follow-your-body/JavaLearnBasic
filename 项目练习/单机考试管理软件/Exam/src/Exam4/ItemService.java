package Exam4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Exam3.Item;

public class ItemService {
	Item[] items;
	
	/**
	 * �޲ι�����
	 * */
	public ItemService() {
		super();
		items = new Item[10];
	}
	
	
	/**
	 * �вι�����
	 * һ��ItemService���󡪡�10��Item����
	 * this�ж�ȡreadTextFile��filename���ļ����ݸ�ֵ��List<String> list
	 * Ȼ��list�е���Ϣ��Ӧ��ֵ��Item���������
	 * */
	public ItemService(String filename) {
		items = new Item[10];
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
	public Item getItem(int index) {
		return items[index];
	}
	

	/**
	 * �÷����ɶ�ȡ����ָ�����ı��ļ����� ����ʹ�ð�װ��������ӡ�������Ļ�ϡ�
	 * @param filename
	 * */
	public List<String> readTextFile(String filename){
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File(filename));
			br = new BufferedReader(fr);
			char[] c = new char[20];
			int len;
			while((len = br.read(c)) != -1) {
				list.add(new String(c, 0, len));
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
			for(int i = 0; i < answer.length; i++) {
				oos.writeObject(answer[i]);
			}
		} catch (FileNotFoundException e) {
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
