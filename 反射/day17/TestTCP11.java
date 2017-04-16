/*
 *实现客户端向服务端发送短信，写什么发送什么，直至客户端写“exit”结束通信 
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

	// 客户端
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.01", 9090);
			os = socket.getOutputStream();
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你想对服务端说的话,以exit结束");
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

	// 服务端：接受客户端的信息，将接收到的信息发送到控制台上
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
//		System.out.println("输入一段字：");
//		str = s.nextLine();
//		while(!str.equals("exit")) {
//			System.out.print("你输入的字符串为： " + str +"  字符串的长度为： " + str.length());
//			System.out.println("  继续输入：");
//			str = s.next();
//		}
//		System.out.println("输入结束了！");
//	}

}
