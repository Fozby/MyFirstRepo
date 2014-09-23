package ken.notken.lol;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;

public class ImageToText
{
	//Sometimes reads 2 as Z, may need to iterate chars and replace with most likely integer
	//Remove $ symbol
	//Completely missreads when font size is scaled for 6 tables
	//Works with 4 table scaling
	
	public static void main(String[] args)
	{
		try
		{
			File imageFile = new File(getAbsoluteFilePath("NovaPot2300_4table.png"));
			Tesseract tess = Tesseract.getInstance();
			
			String imgText = tess.doOCR(imageFile);
			System.out.println("Image: " + imgText);
		}
		catch (Throwable t)
		{
			System.out.println("Error: " + t + ", " + t.getMessage());
			System.out.println(t.getStackTrace());
		}
	}
	
	private static String getAbsoluteFilePath(String fileName)
	{
		String absPath = ImageToText.class.getResource("/resources/" + fileName).getFile();
		File file = new File(absPath);
		
		return file.getAbsolutePath();
	}
}