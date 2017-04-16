/**
 * 题目
 * 该类是对题目对象进行操作
 * 
 * 评价
 * 1.readTextFile(String filename)
 * 2.构造函数
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
	 * 有参构造器
	 * 一个ItemService对象——10个Item对象
	 * this中读取readTextFile（filename）文件内容赋值给List<String> list
	 * 然后将list中的信息对应赋值给Item对象的属性
	 * */
	public ItemService() {
		items = new Item[10];    //TODO Item对象个数也可因做成成员变量的形式
		String filename = "E:\\Users\\danay\\workspace\\Exam\\Items.txt";     //TODO 从代码的重复性来看，filename可以做成成员变量的形式
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
	public Item getItem(int no) {   //TODO 如果超出范围应该怎么办？？
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
			FileReader fr = new FileReader(new File(filename));   //TODO 这里直接写名字就好，不用new了
			br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) {  //TODO 这里没有去掉空行，给后面的读取留了一个隐患
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
	 * 该方法创建answer.dat二进制文件，并将数组中的内容以对象形式写入到文件中保存。
	 * 提示：使用对象序列化机制
	 * */
	public void saveAnswer(char[] answer) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("answer.dat"));
			oos = new ObjectOutputStream(fos);
			for(int i = 0; i < answer.length; i++) {     //TODO 对象写入时可以一同写入，即：oos.writeObject(answer);
				oos.writeObject(answer[i]);
			}
		} catch (FileNotFoundException e) {    //TODO 异常抛一个就可以了
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
