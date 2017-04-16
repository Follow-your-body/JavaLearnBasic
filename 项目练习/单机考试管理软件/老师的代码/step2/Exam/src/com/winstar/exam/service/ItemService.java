package com.winstar.exam.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.winstar.exam.domain.Item;

public class ItemService {
	Item[] items = new Item[10];

	public ItemService() {
		// ��Ҫ��list���Ϻϳɵ�item������,1.��ȥ�ϳɼ����еĵ�һ����Ŀ
		ArrayList<String> list = readTextFile("items.txt");
		/*
		 * String question = list.get(0); String[] option = { list.get(1),
		 * list.get(2), list.get(3), list.get(4) }; String answer = list.get(5);
		 * Item item = new Item(question, option, answer);
		 * 
		 * String question1 = list.get(6); String[] option1 = { list.get(7),
		 * list.get(8), list.get(9), list.get(10) }; String answer1 =
		 * list.get(11); Item item1 = new Item(question1, option1, answer1);
		 */
		// 2.����һ����Ŀ�Ƶ����ϳɶ����Ŀ�Ĺ���,������ӵ�������
		for (int i = 0; i < 10; i++) {
			String question1 = list.get(6 * i);
			String[] option1 = { list.get(6 * i + 1), list.get(6 * i + 2),
					list.get(6 * i + 3), list.get(6 * i + 4) };
			String answer1 = list.get(6 * i + 5);
			Item item1 = new Item(question1, option1, answer1);
			items[i] = item1;
		}

	}
	 public Item getItem(int no){
		 //2.��׳��
		 if(no<1||no>10){
			 return null; 
		 }
		 //1.���Ĺ���
		 return items[no-1];
	 }

	public ArrayList<String> readTextFile(String filename) {
		BufferedReader br = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				// System.out.println(str);
				// ɾ������
				if (!str.equals("")) {

					list.add(str);
				}
				str = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}

	// �û�������ȡ�ļ�,���ԣ���ʱ��
	public void readTextFile1(String filename) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);
			char[] cbuf = new char[500];
			int n = fr.read(cbuf);
			while (n != -1) {
				System.out.println(new String(cbuf, 0, n));
				n = fr.read(cbuf);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
