package day17;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*IP
 * 1.如何创建InetAddress的对象：InetAddress.getByName(String str)【域名+地址都可以】
 * 2.创建的对象可以获取什么（域名+IP地址）
 *端口号
 * 1.标识计算机上正在运行的进程（程序），不同进程有不同的端口号，用16位正数来控制（常用1-24~65535）
 * 
 * */
public class TestInetAddress1 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		// 1.获取网络域名+IP：www.baidu.com/220.181.112.244（域名+IP）
		System.out.println(inet); 
		System.out.println(inet.getHostName()); 
		System.out.println(inet.getHostAddress()); 
		// 2.获取本地域名+IP：LAPTOP-PSHJLL4P / 	10.10.22.18
		System.out.println(inet.getLocalHost().getHostName()); 
		System.out.println(inet.getLocalHost().getHostAddress()); 
	}

}
