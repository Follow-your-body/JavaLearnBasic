// �ͻ��˷���ͼƬ������ˣ�����˽���ͼƬ����ͼƬ���浽���أ����ظ��ͻ��ˡ����յ��ļ���
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
	
	//���ͻ���
	@Test
	public void client() {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 9090);		
			is = socket.getInputStream();
			os = socket.getOutputStream();
			
			// ��ȡͼƬ��Ϣ�����͸������
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
	
	
	//������ˡ�
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
			
			//��ȡ�ͻ��˷��͵���Ϣ�����Ҹ��Ƶ�����
			FileOutputStream fos = new FileOutputStream(new File("����.jpg"));
			byte[] b = new byte[20];
			int len;
			while((len = is.read(b)) != -1) {
				fos.write(b);
			}
			//��֪�ͻ��ˡ��ѽ�����ϡ�
			os.write("���յ����͵�ͼƬ".getBytes());
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
