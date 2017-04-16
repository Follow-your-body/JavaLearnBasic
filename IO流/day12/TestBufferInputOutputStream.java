package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestBufferInputOutputStream {
	@Test
	public void testBufferInputOutputStream1() {
		long start = System.currentTimeMillis();
		System.out.println("start=" + start);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File fileI = new File("1.wmv");
			File fileO = new File("2.wmv");
			FileInputStream fis = new FileInputStream(fileI);
			FileOutputStream fos = new FileOutputStream(fileO);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[20];
			int len;
			while((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {			
			if(bos != null) {			
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bis != null) {			
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("将bis的非文本文件，以字节流的形式赋值给非文本文件bos");
			long end = System.currentTimeMillis();
			System.out.println("end=" + end);
			System.out.println("花费的时间为：" + (end - start));//286
		}	
	}
	
}
