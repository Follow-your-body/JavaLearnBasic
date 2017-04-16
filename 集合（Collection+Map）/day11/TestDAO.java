/*
	创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
	使用 Junit 单元测试类进行测试。
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
		
		System.out.println("删除“001”的信息");
		dao.delete("001");
		System.out.println(dao);
		
		System.out.println("获取“001”的信息");		
		System.out.println(dao.get("002"));
		
		System.out.println("获取所有的values的信息");		
		System.out.println(dao.list());		
	}

}
