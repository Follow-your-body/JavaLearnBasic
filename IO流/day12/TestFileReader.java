package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReader {
	@Test
	public void testFileReader() {
		FileReader fr = null;
		try {
			File file = new File("Hello1.txt");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
				System.out.println(new String(c, 0, len));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
		@Test
		public void testFileWriter() {
			FileWriter fw = null;
			try {
				File file = new File("testFileWriter.txt");
				fw = new FileWriter(file);
				fw.write("qwert");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		@Test
		public void testFileWriterReader() {
			FileWriter fw = null;
			FileReader fr = null;
			try {
				File filew = new File("hello1.txt");
				File filer = new File("testFileWriter.txt");
				fr = new FileReader(filer);
				fw = new FileWriter(filew);
				char[] c = new char[20];
				int len;
				while((len = fr.read(c)) != -1) {
					fw.write(c);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					System.out.println("testFileWriter文本内容复制到hello1中……");
					fr.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
}
