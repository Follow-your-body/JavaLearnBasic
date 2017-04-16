/*
 *客户端向服务器发送一条消息，服务器将接受的消息显示到控制台上并且恢复客户端说“已收到你的短信” 
 */
package day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestTCP12 {
	@Test
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			socket = new Socket("127.0.0.1", 9091);
			os = socket.getOutputStream();
			os.write("服务器端你好吗？".getBytes());
			
			socket.shutdownOutput();
			
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}
	
	
	
	@Test 
	public void server() {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(9091);
			s = ss.accept();
			is = s.getInputStream();
			
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b)) != -1) {
				System.out.println(new String(b, 0, len));
			}
			
			os = s.getOutputStream();
			os.write("已收到你的短信".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
