package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestBufferReaderWriter {
	@Test
	public void testBufferReaderWriter() {
		BufferedReader bfr = null;
		BufferedWriter bfw = null;
		try {
			File fileI = new File("hello1.txt");
			File fileO = new File("hello2.txt");
			FileReader fr = new FileReader(fileI);
			FileWriter fw = new FileWriter(fileO);
			bfr = new BufferedReader(fr);
			bfw = new BufferedWriter(fw);
			char[] c = new char[2];
			int len;
			// 读取
			String str;
			System.out.println("readLine()读取文件…………");
			System.out.println("复制文件…………");
			while((str = bfr.readLine()) != null) {
				System.out.println(str);
				bfw.write(str);
				bfw.newLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	
			System.out.println("复制完成……");
			if(bfw != null){			
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bfr != null){			
				try {
					bfr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
  	}

}
