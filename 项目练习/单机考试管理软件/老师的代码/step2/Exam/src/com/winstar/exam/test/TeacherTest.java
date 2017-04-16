package com.winstar.exam.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.winstar.exam.service.ItemService;

/*
 * 散装数据合成对象
 */
public class TeacherTest {
	public static void main(String[] args) {
		// 1散装数据
		String name = "zhang3";
		String gender = "男";
		String cls = "190";

		// 1 将散装数据合成到t对象中
		Teacher t = new Teacher(name, gender, cls);
		String cls1 = t.getCls();
		// 2.将文件中的数据变读取边存入对象中
		readTeacher();
		
		// 3从文件读取数据存入到集合中，然后将集合中的数据存入到对象中
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
			// 取出来的散装数据
			String name = br.readLine();
			String gender = br.readLine();
			String cls = br.readLine();

			// 和成对象
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
