package day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class testPicture {
	public static void main(String[] args) throws FileNotFoundException {
		// �ҵ�ͼƬ��λ��
		File file = new File("E:\\Users\\danay\\workspace\\java\\1.jpg");
		if(file.exists()) {			
			FileInputStream fis = new FileInputStream(file);
			// ����Ϳ��Դ���ͼƬ
		}
		
		
	}
}
