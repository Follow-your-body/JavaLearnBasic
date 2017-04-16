package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class testPicture {
	public static void main(String[] args) throws FileNotFoundException {
		// 找到图片的位置
		File file = new File("E:\\Users\\danay\\workspace\\java\\1.jpg");
		if(file.exists()) {			
			FileInputStream fis = new FileInputStream(file);
			// 这里就可以处理图片
		}
		
		
	}
}
