/**
 * ��Ŀ
 * �����Ƕ���Ŀ������в���
 * */
package Exam9Optimize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemServiceOptimize {
	ItemOptimize[] items;
	private final int INTEMCOUNT = 10;
	private final int ROW = 7;
	private final String FILENAME = "E:\\Users\\danay\\workspace\\Exam\\Items.txt";

	/**
	 * �вι����� һ��ItemService���󡪡�10��Item����
	 * this�ж�ȡreadTextFile��filename���ļ����ݸ�ֵ��List<String> list
	 * Ȼ��list�е���Ϣ��Ӧ��ֵ��Item���������
	 */
	public ItemServiceOptimize() {
		items = new ItemOptimize[INTEMCOUNT];
		List<String> list = this.readTextFile(FILENAME);
		for (int i = 0; i < INTEMCOUNT; i++) {
			 String subject = list.get(ROW * i);
			 String[] option = {list.get(ROW * i + 1), list.get(ROW * i + 2),
			 list.get(ROW * i + 3), list.get(ROW * i + 4)};
			 String answer = list.get(ROW * i + 5);
			 items[i] = new ItemOptimize(subject, option, answer);
		}
	}

	/**
	 * ��ȡ����
	 */
	public ItemOptimize getItem(int no) {
		if (no >= 0 && no < INTEMCOUNT) {
			return items[no];
		}
		return null;
	}

	/**
	 * �÷����ɶ�ȡ����ָ�����ı��ļ����� ����ʹ�ð�װ��������ӡ�������Ļ�ϡ�
	 * 
	 * @param filename
	 */
	private List<String> readTextFile(String filename) {
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String str;
			while ((str = br.readLine()) != null) {
				list.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
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
	 * �÷�������answer.dat�������ļ������������е������Զ�����ʽд�뵽�ļ��б��档 ��ʾ��ʹ�ö������л�����
	 */
	public void saveAnswer(char[] answer) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("answer.dat"));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(answer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ��ȡ�� ��ʾ��ʹ�ö������л�����
	 */
	public char[] readAnswer(String fileName) {
		ObjectInputStream ois = null;
		char[] chs = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			chs = (char[]) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return chs;
	}

}
