package com.winstar.exam.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemService {
	public ArrayList<String> readTextFile(String filename) {
		BufferedReader br = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			FileReader fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String str = br.readLine();
			while (str != null) {
				// System.out.println(str);
				//删除空行
				if(!str.equals("")){
					
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

	// 用基本流读取文件,尝试，过时了
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
