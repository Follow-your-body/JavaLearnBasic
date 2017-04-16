/*
	���� DAO ��Ķ��� �ֱ������ save��get��update��list��delete ���������� User ����
	ʹ�� Junit ��Ԫ��������в��ԡ�
 */
package day11;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestDAO {
	
	@Test
	public void testDAO() {
		DAO<User> dao = new DAO<>(); 
		dao.map = new HashMap<String, User>();
		dao.save("001", new User(22, 12, "danay"));
		dao.save("002", new User(23, 12, "anna"));
		dao.save("003", new User(24, 12, "Dive"));
		System.out.println(dao);
		
		System.out.println("ɾ����001������Ϣ");
		dao.delete("001");
		System.out.println(dao);
		
		System.out.println("��ȡ��001������Ϣ");		
		System.out.println(dao.get("002"));
		
		System.out.println("��ȡ���е�values����Ϣ");		
		System.out.println(dao.list());		
	}

}
