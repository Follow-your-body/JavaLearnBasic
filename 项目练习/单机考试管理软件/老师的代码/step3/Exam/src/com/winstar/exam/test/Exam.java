package com.winstar.exam.test;

import com.winstar.exam.domain.Item;
import com.winstar.exam.service.ItemService;
import com.winstar.exam.view.ExamView;

public class Exam {
	public static void main(String[] args) {
		ItemService service = new ItemService();

		// Item item = service.getItem(5);
		// if (item == null) {
		// System.out.println("Ã‚∫≈≤ª∂‘");
		// } else {
		// System.out.println(item);
		// }
		// char[] chs={'a','1','b'};
		// service.saveAnswer(chs);
		// char[] result=service.readAnswer();
		// System.out.println(result);
//		int n2 = 3;
//		int m = 2;
//		System.out.println(m + n2);

		ExamView ev = new ExamView();
		ev.testExam();

	}
}
