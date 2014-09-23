package ken.notken.lol;

import java.io.File;
import java.util.Properties;

import com.asprise.ocr.Ocr;

public class aocr
{
	public static void main(String[] args)
	{
		Ocr ocr = new Ocr();
		ocr.setUp();
		ocr.startEngine("eng", Ocr.SPEED_FASTEST);
		
		
		File imageFile = new File(getAbsoluteFilePath("Azure424.png"));
		
		File[] files = new File[1];
		files[0] = imageFile;

		Properties prop = new Properties();
		
		String s = ocr.recognize(files, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT, prop);
		System.out.println("Str: " + s);
	}
	
	private static String getAbsoluteFilePath(String fileName)
	{
		String absPath = aocr.class.getResource("/resources/" + fileName).getFile();
		File file = new File(absPath);
		
		return file.getAbsolutePath();
	}
}