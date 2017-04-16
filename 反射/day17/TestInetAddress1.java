package day17;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*IP
 * 1.��δ���InetAddress�Ķ���InetAddress.getByName(String str)������+��ַ�����ԡ�
 * 2.�����Ķ�����Ի�ȡʲô������+IP��ַ��
 *�˿ں�
 * 1.��ʶ��������������еĽ��̣����򣩣���ͬ�����в�ͬ�Ķ˿ںţ���16λ���������ƣ�����1-24~65535��
 * 
 * */
public class TestInetAddress1 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		// 1.��ȡ��������+IP��www.baidu.com/220.181.112.244������+IP��
		System.out.println(inet); 
		System.out.println(inet.getHostName()); 
		System.out.println(inet.getHostAddress()); 
		// 2.��ȡ��������+IP��LAPTOP-PSHJLL4P / 	10.10.22.18
		System.out.println(inet.getLocalHost().getHostName()); 
		System.out.println(inet.getLocalHost().getHostAddress()); 
	}

}
