package Exam3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemService {
	Item[] items;
	
	/**
	 * 有参构造器
	 * 一个ItemService对象——10个Item对象
	 * this中读取readTextFile（filename）文件内容赋值给List<String> list
	 * 然后将list中的信息对应赋值给Item对象的属性
	 * */
	public ItemService() {
		items = new Item[10];
		String filename = "E:\\Users\\danay\\workspace\\Exam\\Items.txt";
		List<String> list = this.readTextFile(filename);
		for(int i = 0; i < 10; i++) {
			Item item = new Item(list.get(7 * i), list.get(7 * i + 1), list.get(7 * i + 2),
					list.get(7 * i + 3), list.get(7 * i + 4), list.get(7 * i + 5));
			items[i] = item;
		}
	}
	
	
	/**
	 * 获取对象
	 * */
	public Item getItem(int no) {
		return items[no];
	}
	

	/**
	 * 该方法可读取参数指定的文本文件内容 （不使用包装），并打印输出到屏幕上。
	 * @param filename
	 * */
	private List<String> readTextFile(String filename){
		List<String> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File(filename));
			br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) {
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

}

////		读取对应的对象显示
//		for(int i = 0; i < 10; i++) {
//			System.out.println(is.getItem(i).getSubject());
//			System.out.println(is.getItem(i).getOptionA());
//			System.out.println(is.getItem(i).getOptionB());
//			System.out.println(is.getItem(i).getOptionC());
//			System.out.println(is.getItem(i).getOptionD());
//			System.out.println(is.getItem(i).getAnswer());
//			System.out.println();			
//		}