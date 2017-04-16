package day17;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.omg.CORBA_2_3.portable.InputStream;

public class TestURL {
	@Test
	public void test() throws Exception {
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.getProtocol());   // 协议名
		System.out.println(url.getFile());  //  获取文件名
		System.out.println(url.getHost());	// 主机域名
		System.out.println(url.getPort());  // 端口号
		System.out.println(url.getQuery());  // URL的查询名
		System.out.println();
		InputStream is = (InputStream) url.openStream();
		byte[] b = new byte[20];
		int len;
		while((len = is.read(b)) != -1) {
			System.out.println(new String(b, 0, len));
		}
	}

}
