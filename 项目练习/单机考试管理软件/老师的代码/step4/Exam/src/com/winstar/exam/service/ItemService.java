package com.winstar.exam.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.winstar.exam.domain.Item;

public class ItemService {
	private static final String FIlEANSWER = "answer.dat";
	private final int ITEMCOUNT=6;
	private int total;//һ���ж��ٸ���Ŀ
	Item[] items ;

	public int getTotal() {
		return total;
	}

	public ItemService() {

		ArrayList<String> list = readTextFile("items.txt");
		total=list.size()/ITEMCOUNT;
		items= new Item[total];
		// ����һ����Ŀ�Ƶ����ϳɶ����Ŀ�Ĺ���,������ӵ�������
		for (int i = 0; i < total; i++) {
			String question1 = list.get(ITEMCOUNT * i);
			String[] option1 = { list.get(ITEMCOUNT * i + 1), list.get(ITEMCOUNT * i + 2),
					list.get(ITEMCOUNT * i + 3), list.get(ITEMCOUNT * i + 4) };
			String answer1 = list.get(ITEMCOUNT * i + 5);
			Item item1 = new Item(question1, option1, answer1);
			items[i] = item1;
		}

	}

	public Item getItem(int no) {
		// 2.��׳��
		if (no < 1 || no > 10) {
			return null;
		}
		// 1.���Ĺ���
		return items[no - 1];
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

	/*
	 * �����
	 */�������ͺͲ����ǿ��Լ��Ƿ���Ҫ��ӵģ�
	public void saveAnswer(char[] answer) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(FIlEANSWER);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(answer);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * ��ȡ��
	 */
	public char[] readAnswer() {
		ObjectInputStream ois = null;
		char[] chs = null;
		try {
			FileInputStream fis = new FileInputStream(FIlEANSWER);
			ois = new ObjectInputStream(fis);
			chs = (char[]) ois.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return chs;

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
