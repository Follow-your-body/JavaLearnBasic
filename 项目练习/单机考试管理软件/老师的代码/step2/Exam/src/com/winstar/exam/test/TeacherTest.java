package com.winstar.exam.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.winstar.exam.service.ItemService;

/*
 * ɢװ���ݺϳɶ���
 */
public class TeacherTest {
	public static void main(String[] args) {
		// 1ɢװ����
		String name = "zhang3";
		String gender = "��";
		String cls = "190";

		// 1 ��ɢװ���ݺϳɵ�t������
		Teacher t = new Teacher(name, gender, cls);
		String cls1 = t.getCls();
		// 2.���ļ��е����ݱ��ȡ�ߴ��������
		readTeacher();
		
		// 3���ļ���ȡ���ݴ��뵽�����У�Ȼ�󽫼����е����ݴ��뵽������
		ItemService service = new ItemService();
		List<String> ts = service.readTextFile("teacher.txt");
		String name1 = ts.get(0);
		String gender1 = ts.get(1);
		String cls2 = ts.get(2);
		
		String name3 = ts.get(3);
		String gender3 = ts.get(4);
		String cls3 = ts.get(5);
		Teacher t1=new Teacher(name1, gender1, cls2);
		Teacher t2=new Teacher(name3, gender3, cls3);
		
		System.out.println(t1);
		System.out.println(t2);

	}

	private static void readTeacher() {
		BufferedReader br = null;

		try {
			FileReader fr = new FileReader("teacher.txt");
			br = new BufferedReader(fr);
			// ȡ������ɢװ����
			String name = br.readLine();
			String gender = br.readLine();
			String cls = br.readLine();

			// �ͳɶ���
			Teacher t = new Teacher(name, gender, cls);
			System.out.println(t);

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
	}
}
