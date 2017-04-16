/**
 * 题目
 * 该类是对题目对象进行操作
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
	 * 有参构造器 一个ItemService对象——10个Item对象
	 * this中读取readTextFile（filename）文件内容赋值给List<String> list
	 * 然后将list中的信息对应赋值给Item对象的属性
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
	 * 获取对象
	 */
	public ItemOptimize getItem(int no) {
		if (no >= 0 && no < INTEMCOUNT) {
			return items[no];
		}
		return null;
	}

	/**
	 * 该方法可读取参数指定的文本文件内容 （不使用包装），并打印输出到屏幕上。
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
	 * 该方法创建answer.dat二进制文件，并将数组中的内容以对象形式写入到文件中保存。 提示：使用对象序列化机制
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
	 * 读取答案 提示：使用对象序列化机制
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
