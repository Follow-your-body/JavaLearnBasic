/*
 *ʵ�ֿͻ��������˷��Ͷ��ţ�дʲô����ʲô��ֱ���ͻ���д��exit������ͨ�� 
 */
package day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class TestTCP11 {

	// �ͻ���
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.01", 9090);
			os = socket.getOutputStream();
			Scanner scanner = new Scanner(System.in);
			System.out.println("����������Է����˵�Ļ�,��exit����");
			String str = scanner.nextLine();
			while (!str.equals("exit")) {
				os.write(str.getBytes());
				str = scanner.nextLine();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ����ˣ����ܿͻ��˵���Ϣ�������յ�����Ϣ���͵�����̨��
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b = new byte[20];
			int len;
			while ((len = is.read(b)) != -1) {
				System.out.print(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
//	@Test
//	public void test() {
//		Scanner s = new Scanner(System.in);
//		String str;
//		System.out.println("����һ���֣�");
//		str = s.nextLine();
//		while(!str.equals("exit")) {
//			System.out.print("��������ַ���Ϊ�� " + str +"  �ַ����ĳ���Ϊ�� " + str.length());
//			System.out.println("  �������룺");
//			str = s.next();
//		}
//		System.out.println("��������ˣ�");
//	}

}
