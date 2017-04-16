package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {
	
	@Test
	public void testgeneric1() {
		List list = new ArrayList();
		// 1,û��ʹ�÷��ͣ��κε�Object���͵Ķ��󶼿�����ӽ���
		list.add(122);
		list.add(12);
		list.add(23);
		list.add("22");
		// ǿת��Iteger����ʱ�������ClassCastException�쳣
		for(Object obj : list) {
			System.out.println((Integer)obj);
		}
	}
	
	@Test
	public void testgeneric2() {
		// �ڼ�����ʹ������(ֻ�����������Ͳ����ǻ�����������)
		List<Integer> list = new ArrayList<Integer>();
		list.add(122);
		list.add(12);
		list.add(23);
		// �˴�û����ӷ��ͷ��ϵ����ͣ�����ͻᱨ��
		// The method add(Integer) in the type List<Integer> is not applicable for the arguments (String)
//		list.add("22");
		// ������ʱ�������͵�ǿ��ת�������ͱ���˶�����������ͣ��˴�ΪInteger��
		for(Integer obj : list) {
			System.out.println(obj);
		}
		
		// map����
		Map<String, Integer> map = new HashMap<>();
		map.put("danay", 12);
		map.put("anna", 11);
		map.put("sillive", 10);
		System.out.println(map);
		
		// ��Map�԰�Set����(����ΪMap.Entry<String, Integer>)
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> obj : set) {
			System.out.println(obj.getValue());
		}
		
	}
	
	@Test
	public void testOrder() {
		// ָ��Order�ķ�����ΪBoolean����(��������Զ�������ת�������͵���)
		// ���δ�������ͣ�Ĭ��ΪObject����
		Order<Boolean> order = new Order<Boolean>();
		order.setOrderId("11");
		// ���巺�����еķ�����������ΪBoolean��������
		order.setT(true);
		System.out.println(order.getT());
		
		// �������������еķ����������ͣ�Ȼ�������Ѿ����巺���������͵Ķ�����÷��ͺ���
		Integer i = order.getE(23);
		Integer i1 = order.getE(34);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
