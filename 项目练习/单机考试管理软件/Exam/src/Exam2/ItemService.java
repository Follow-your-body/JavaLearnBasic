package Exam2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemService {
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) {
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
	
}
