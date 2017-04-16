package day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestInputAndReaderStream {
	
	/*
	 字节流的形式，写入test1.txt文件内容
	 */ 
	@Test
	public void testOnputStream1() {
		System.out.println("写入test1.txt文件内容……");
		BufferedOutputStream bos1 = null;
		try {
			File file1 = new File("test1.txt");
			if(!file1.exists()) {
				file1.createNewFile();
			}
			FileOutputStream fos1 = new FileOutputStream(file1);
			bos1 = new BufferedOutputStream(fos1);
			String str = "java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，\n"
					+ "是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和\n"
					+ "Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的\n"
					+ "通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、\n"
					+ "游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。\n"
					+ "在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。\n";
			bos1.write(str.getBytes());	
			bos1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("完成！");
			if(bos1 != null) {				
				try {
					bos1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 字符流的形式，写入test11.txt文件内容
	 */ 
	@Test
	public void testWriter1() {
		System.out.println("字符流的形式，写入test11.txt文件内容……");
		BufferedWriter bw = null;
		try {
			File file1 = new File("test11.txt");
			if(!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fw = new FileWriter(file1);
			bw = new BufferedWriter(fw);
			String str = "java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，\n"
					+ "是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和\n"
					+ "Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓越的\n"
					+ "通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、\n"
					+ "游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。\n"
					+ "在全球云计算和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。\n";
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("完成！");
			if(bw != null) {				
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 字节流的形式
	利用程序读取test.txt文件内容，并在控制台打印 
	 将test1.txt中的内容用字节流的形式复制到test2.txt中
	 */
	@Test
	public void testInputStreamCopy() {
		System.out.println("利用程序读取test.txt文件内容，并在控制台打印……\n");
		BufferedOutputStream bos = null;
		try {
			File fileI = new File("test1.txt");
			FileInputStream fis = new FileInputStream(fileI);
			BufferedInputStream bis = new BufferedInputStream(fis);
			File fileO = new File("test2.txt");
			FileOutputStream fos = new FileOutputStream(fileO);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[20];
			int len;
			while((len = bis.read(b)) != -1) {
				System.out.print(new String(b, 0, len));
				bos.write(b);
				bos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("\n完成！");
			System.out.println("将test1.txt中的内容用字节流的形式复制到test2.txt中……");
			System.out.println("完成！");
			if(bos !=null) {				
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 字符流的形式
	利用程序读取test11.txt文件内容，并在控制台打印 
	 将test11.txt中的内容用字节流的形式复制到test22.txt中
	 */
	@Test
	public void testWriterCopy() {
		System.out.println("利用程序读取test11.txt文件内容，并在控制台打印 ……\n");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File fileI = new File("test11.txt");
			FileReader fr = new FileReader(fileI);
			br = new BufferedReader(fr);
			File fileO = new File("test22.txt");
			FileWriter fw = new FileWriter(fileO);
			bw= new BufferedWriter(fw);
			String str;
			while((str = br.readLine()) != null) {
				System.out.print(str);
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("\n完成！");
			System.out.println(" 将test11.txt中的内容用字节流的形式复制到test22.txt中……");
			System.out.println("完成！");
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br !=null) {				
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