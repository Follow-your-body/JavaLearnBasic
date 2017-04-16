/*
 �ļ���(�ڵ���)
	���ֽ�����FileInputStream / FileOutputStream ������Ƶ����Ƶ��ͼƬ
	���ַ�����FileReader / FileWriter�����ı��ļ�.doc+.txt
����������������
	���ֽڻ�������BufferedInputStream / BufferedOutputStream 
	���ַ���������BufferedReader / BufferedWriter
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
	 * read()���ֽڶ�ȡ�ļ�������ļ�û�з���-1
	 * 
	 * ��������ļ�Ҫ��������
	 * 
	 * ��Ӳ�̴��ڵ�һ���ļ��У���ȡ�����ݵ������С�ʹ��FileInputStream
	 * Ҫ��ȡ���ļ�һ��Ҫ���ڡ�������FileNotFoundException
	 * 
	 * ���⣺������쳣�׳������ֽ������ܾͲ��ر��ˣ��˷��ڴ棬����ʽtestInputStream2����
	 * */
	@Test
	public void testInputStream1() throws Exception {
		// 1.����һ��File���󣬱���Ҫд����ļ�λ��
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
	 * ��try-catch�ķ�ʽ�����쳣�����������׳��쳣�ͽ���
	 * ��finally�йر�����������Ϊ�ر���Ҳ�п������쳣���ټ�һ��try-catch
	 * 
	 * ȱ�㣺�����һ��һ�����ֽ�����ȡ��ռ�ſռ�+�ٶȺ�������������ķ�ʽ��ȡ�ȽϺã�ˮվ��ˮ��һ���Ͷ�Ͱ����Լʱ�䣩��testInputStream3
	 * */
	@Test
	public void testInputStream2() {
		// 1.����һ��File���󣬱���Ҫд����ļ�λ��
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
	 * read(byte[] b)���ֽڵĳ��ȶ�ȡ�ļ� 
	 * ���� ��ʽ�Ǳ��������õ����ͣ�ǰ���ֶ�ȡ��ʽ���ȿɲ���Ҫʹ��
	 * 
	 * ȱ�㣺Ҳ���ֽ�����ȱ�㣺���ܷ�������ȡ+���ܶ�����
	 * 
	 * ����дһ���ֽ����������
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
	 * FileOutputStreamҲ�ǰ��ֽ�д�룬д��ʱ�ý��Լ�������.getBytes()��ʽ����ת�����ֽڵ���ʽ�Ϳ���д��ȥ��
	 * 
	 * ���������ļ����� �����ڣ�д��ʱ���Լ�����
	 * 
	 * ȱ�㣺�ٴ�д���ʱ��ͻḲ��ԭ��������
	 * 
	 * ������������ֽ���������ϰ��TestInputOutputStream
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
	
	/*������������������ϰ*/
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
				fosO.write(b, 0, len);   // ��ΪbΪ�ֽ����飬����д���ʱ����볤�����棬������fosO.write(b)
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				System.out.println("fileI�����ݸ��Ƶ�fileO�У�������ɣ���");
				fisI.close();
				fosO.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		long end = System.currentTimeMillis();
		System.out.println("���ѵ�ʱ��Ϊ��" + (end - start));  // 8845
	}
	
}
