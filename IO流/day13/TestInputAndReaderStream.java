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
	 �ֽ�������ʽ��д��test1.txt�ļ�����
	 */ 
	@Test
	public void testOnputStream1() {
		System.out.println("д��test1.txt�ļ����ݡ���");
		BufferedOutputStream bos1 = null;
		try {
			File file1 = new File("test1.txt");
			if(!file1.exists()) {
				file1.createNewFile();
			}
			FileOutputStream fos1 = new FileOutputStream(file1);
			bos1 = new BufferedOutputStream(fos1);
			String str = "java��һ�ֿ���׫д��ƽ̨Ӧ��������������ĳ���������ԣ�\n"
					+ "����Sun Microsystems��˾��1995��5���Ƴ���Java����������Ժ�\n"
					+ "Javaƽ̨����JavaSE, JavaEE, JavaME�����ܳơ�Java ��������׿Խ��\n"
					+ "ͨ���ԡ���Ч�ԡ�ƽ̨��ֲ�ԺͰ�ȫ�ԣ��㷺Ӧ���ڸ���PC���������ġ�\n"
					+ "��Ϸ����̨����ѧ������������ƶ��绰�ͻ�������ͬʱӵ��ȫ�����Ŀ�����רҵ��Ⱥ��\n"
					+ "��ȫ���Ƽ�����ƶ��������Ĳ�ҵ�����£�Java���߱����������ƺ͹���ǰ����\n";
			bos1.write(str.getBytes());	
			bos1.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("��ɣ�");
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
	 �ַ�������ʽ��д��test11.txt�ļ�����
	 */ 
	@Test
	public void testWriter1() {
		System.out.println("�ַ�������ʽ��д��test11.txt�ļ����ݡ���");
		BufferedWriter bw = null;
		try {
			File file1 = new File("test11.txt");
			if(!file1.exists()) {
				file1.createNewFile();
			}
			FileWriter fw = new FileWriter(file1);
			bw = new BufferedWriter(fw);
			String str = "java��һ�ֿ���׫д��ƽ̨Ӧ��������������ĳ���������ԣ�\n"
					+ "����Sun Microsystems��˾��1995��5���Ƴ���Java����������Ժ�\n"
					+ "Javaƽ̨����JavaSE, JavaEE, JavaME�����ܳơ�Java ��������׿Խ��\n"
					+ "ͨ���ԡ���Ч�ԡ�ƽ̨��ֲ�ԺͰ�ȫ�ԣ��㷺Ӧ���ڸ���PC���������ġ�\n"
					+ "��Ϸ����̨����ѧ������������ƶ��绰�ͻ�������ͬʱӵ��ȫ�����Ŀ�����רҵ��Ⱥ��\n"
					+ "��ȫ���Ƽ�����ƶ��������Ĳ�ҵ�����£�Java���߱����������ƺ͹���ǰ����\n";
			bw.write(str);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("��ɣ�");
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
	 �ֽ�������ʽ
	���ó����ȡtest.txt�ļ����ݣ����ڿ���̨��ӡ 
	 ��test1.txt�е��������ֽ�������ʽ���Ƶ�test2.txt��
	 */
	@Test
	public void testInputStreamCopy() {
		System.out.println("���ó����ȡtest.txt�ļ����ݣ����ڿ���̨��ӡ����\n");
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
			System.out.println("\n��ɣ�");
			System.out.println("��test1.txt�е��������ֽ�������ʽ���Ƶ�test2.txt�С���");
			System.out.println("��ɣ�");
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
	 �ַ�������ʽ
	���ó����ȡtest11.txt�ļ����ݣ����ڿ���̨��ӡ 
	 ��test11.txt�е��������ֽ�������ʽ���Ƶ�test22.txt��
	 */
	@Test
	public void testWriterCopy() {
		System.out.println("���ó����ȡtest11.txt�ļ����ݣ����ڿ���̨��ӡ ����\n");
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
			System.out.println("\n��ɣ�");
			System.out.println(" ��test11.txt�е��������ֽ�������ʽ���Ƶ�test22.txt�С���");
			System.out.println("��ɣ�");
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