// 客户端发送图片给服务端，服务端接收图片，将图片保存到本地，并回复客户端“已收到文件”
package day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestTCP13 {
	
	//　客户端
	@Test
	public void client() {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 9090);		
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			// 读取图片信息，发送给服务端
			FileInputStream fis = new FileInputStream(new File("1.jpg"));
			byte[] b = new byte[20];
			int len;
			while((len = fis.read(b)) != -1) {
				os.write(b);
			}
			socket.shutdownOutput();
			
			while((len = is.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//　服务端　
	@Test
	public void serser() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			is = s.getInputStream();
			os = s.getOutputStream();
			
			//获取客户端发送的信息，并且复制到本地
			FileOutputStream fos = new FileOutputStream(new File("复制.jpg"));
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b)) != -1) {
				fos.write(b);
			}
			//告知客户端“已接收完毕”
			os.write("已收到发送的图片".getBytes());
			s.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
