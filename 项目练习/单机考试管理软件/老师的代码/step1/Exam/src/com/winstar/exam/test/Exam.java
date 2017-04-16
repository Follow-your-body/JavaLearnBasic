package com.winstar.exam.test;

import java.util.List;

import com.winstar.exam.service.ItemService;

public class Exam {
	public static void main(String[] args) {
		ItemService servise = new ItemService();
		List<String> list = servise.readTextFile("items.txt");
		for (String str : list) {
			System.out.println("*"+str);
		}
	}
}
