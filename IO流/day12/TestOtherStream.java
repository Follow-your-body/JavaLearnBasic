package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

import org.junit.Test;

public class TestOtherStream {
	@Test 
	public void testOtherStream1() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file = new File("hello1.txt");
			FileInputStream  fis = new FileInputStream (file);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			
			FileOutputStream fow = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fow, "GBK");
			bw = new BufferedWriter(osw);
			
			String str;
			while((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			if(bw != null) {			
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br != null) {			
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	@Test
	public void testOtherStream2() {
		BufferedReader br = null;
		try {
			InputStream in = System.in;
			OutputStream out = System.out;
			InputStreamReader isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String str;
			while(true) {
				System.out.println("ÇëÊäÈë×Ö·û´®£º");
				str = br.readLine();
				if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					break;
				}
				System.out.println(str.toUpperCase());
			}
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
	}

}
