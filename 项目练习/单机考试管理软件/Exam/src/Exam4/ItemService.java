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
	 * 无参构造器
	 * */
	public ItemService() {
		super();
		items = new Item[10];
	}
	
	
	/**
	 * 有参构造器
	 * 一个ItemService对象——10个Item对象
	 * this中读取readTextFile（filename）文件内容赋值给List<String> list
	 * 然后将list中的信息对应赋值给Item对象的属性
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
	 * 获取对象
	 * */
	public Item getItem(int index) {
		return items[index];
	}
	

	/**
	 * 该方法可读取参数指定的文本文件内容 （不使用包装），并打印输出到屏幕上。
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
	 * 该方法创建answer.dat二进制文件，并将数组中的内容以对象形式写入到文件中保存。
	 * 提示：使用对象序列化机制
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
