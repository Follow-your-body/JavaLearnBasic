/*
 *ʵ�ֿͻ��������˷��Ͷ��ţ�дʲô����ʲô(ֻ�ܷ�һ��)��ֱ���ͻ���д��exit������ͨ�� 
 */
package day17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.junit.Test;

public class TestUDP1 {

	// �ͻ���
	@Test
	public void client() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			// �������ݱ�
			Scanner scanner = new Scanner(System.in);
			String str = scanner.nextLine();
			while (!str.equals("exit")) {
				byte[] b = str.getBytes();
				DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
				// ����
				ds.send(pack);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}

	// �����
	@Test
	public void Server() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			// ��ȡ����
			byte[] b = new byte[1024];
			DatagramPacket pack = new DatagramPacket(b, 0, b.length);
			ds.receive(pack);
			System.out.println(new String(pack.getData(), 0, pack.getLength()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}

}
