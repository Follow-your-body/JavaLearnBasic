/*
 文件流(节点流)
	（字节流：FileInputStream / FileOutputStream ——视频，音频，图片
	（字符流：FileReader / FileWriter——文本文件.doc+.txt
缓冲流（处理流）
	（字节缓冲流：BufferedInputStream / BufferedOutputStream 
	（字符缓冲流：BufferedReader / BufferedWriter
 * */
package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestInputStream {
	/*
	 * read()按字节读取文件，如果文件没有返回-1
	 * 
	 * 该输入的文件要求必须存在
	 * 
	 * 从硬盘存在的一个文件中，读取其内容到程序中。使用FileInputStream
	 * 要读取的文件一定要存在。否则抛FileNotFoundException
	 * 
	 * 问题：如果有异常抛出，该字节流可能就不关闭了，浪费内存，处理方式testInputStream2（）
	 * */
	@Test
	public void testInputStream1() throws Exception {
		// 1.创建一个File对象，表明要写入的文件位置
		File file = new File("hello1.txt");
		FileInputStream input = new FileInputStream(file);
		int b = input.read();
		while(b != -1) {
			System.out.print((char)b);
			b = input.read();
		}
		input.close();
	}
	
	/*
	 * 用try-catch的方式处理异常，而不再是抛出异常就结束
	 * 在finally中关闭输入流，因为关闭流也有可能抛异常，再加一个try-catch
	 * 
	 * 缺点：这个是一个一个的字节来读取，占着空间+速度很慢，将按数组的方式读取比较好（水站送水，一次送多桶，节约时间）：testInputStream3
	 * */
	@Test
	public void testInputStream2() {
		// 1.创建一个File对象，表明要写入的文件位置
			FileInputStream input = null;
			try {
				File file = new File("hello1.txt");
				input = new FileInputStream(file);
				int b = input.read();
				while(b != -1) {
					System.out.print((char)b);
					b = input.read();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
	}
	
	/*
	 * read(byte[] b)按字节的长度读取文件 
	 * 这种 方式是编程中最可用的类型，前两种读取方式理解既可不需要使用
	 * 
	 * 缺点：也是字节流的缺点：不能分行来读取+不能读汉字
	 * 
	 * 下面写一下字节流的输出流
	 * */
	@Test
	public void testInputStream3() {
		FileInputStream fis = null;
		try {
			File file = new File("hello1.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[20]; 
			int len;
			while((len = fis.read(b)) != -1) {
				System.out.print(new String(b, 0, len));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	/*
	 * FileOutputStream也是按字节写入，写入时用将自己付传用.getBytes()形式将其转换成字节的形式就可以写进去了
	 * 
	 * 这个输出的文件可以 不存在，写的时候自己创建
	 * 
	 * 缺点：再次写入的时候就会覆盖原来的内容
	 * 
	 * 将输入和输入字节流相结合练习：TestInputOutputStream
	 * */
	@Test
	public void testOnputStream3() {
		FileOutputStream fos = null;
		try {
			File file = new File("hello2.txt");
			fos = new FileOutputStream(file);
			fos.write(new String("wertyujhgf").getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	/*将输入和输出流相结合练习*/
	@Test
	public void TestInputOutputStream() {
		long start = System.currentTimeMillis();
		FileInputStream fisI = null;
		FileOutputStream fosO = null;
		try {
			File fileI = new File("1.wmv");
			fisI = new FileInputStream(fileI);
			File fileO = new File("2.wmv");
			fosO = new FileOutputStream(fileO);
			
			byte[] b = new byte[20];
			int len;
			while((len = fisI.read(b)) != -1) {
				fosO.write(b, 0, len);   // 因为b为字节数组，所以写入的时候必须长度来存，不能用fosO.write(b)
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				System.out.println("fileI的内容复制到fileO中，复制完成！！");
				fisI.close();
				fosO.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		long end = System.currentTimeMillis();
		System.out.println("花费的时间为：" + (end - start));  // 8845
	}
	
}
