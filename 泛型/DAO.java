/*
 ����������� DAO<T>�������ж���һ��Map ��Ա������Map �ļ�Ϊ String ���ͣ�ֵΪ T ���͡�
	�ֱ𴴽����·�����
	public void save(String id,T entity)�� ���� T ���͵Ķ��� Map ��Ա������
	T get(String id)���� map �л�ȡ id ��Ӧ�Ķ���
	void update(String id,T entity)���滻 map ��keyΪid������,��Ϊ entity ����
	List<T> list()������ map �д�ŵ����� T ����
	void delete(String id)��ɾ��ָ�� id ����
 */
package day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	
	Map<String, T> map;
	
	public void save(String id, T entity) {
		map.put(id, entity);
	}
	
	public T get(String id) {
		return map.get(id);
	}
	
	public void update(String id, T entity) {
		map.put(id, entity);		
	}
	
	public List<T> list() {
		List<T> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
	}
	
	void delete(String id) {
		map.remove(id);
	}

	@Override
	public String toString() {
		return "DAO [map=" + map + "]";
	}
	
}
