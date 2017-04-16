package com.winstar.exam.test;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import com.winstar.exam.domain.Item;
import com.winstar.exam.service.ItemService;

public class Exam {
	public static void main(String[] args) {
		ItemService service = new ItemService();
		// List<String> list = servise.readTextFile("items.txt");
		// for (String str : list) {
		// System.out.println("*"+str);
		// }
		Item item = service.getItem(5);
		if (item == null) {
			System.out.println("Ã‚∫≈≤ª∂‘");
		} else {
			System.out.println(item);
		}

	}
}
