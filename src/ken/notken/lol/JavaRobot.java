package ken.notken.lol;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class JavaRobot
{
	public static Vector<Card> deck = new Vector<Card>();
	
	public static void initCards()
	{
		Card aceDiamonds = new Card(Suit.DIAMONDS, Rank.Ace, getAbsoluteFilePath("AceDiamonds.png"), "Ad");
		Card aceSpades = new Card(Suit.SPADES, Rank.Ace, getAbsoluteFilePath("AceSpades.png"), "As");
		
		Card Kd = new Card(Suit.DIAMONDS, Rank.King, getAbsoluteFilePath("KingDiamonds.png"), "Kd");
		Card Ks = new Card(Suit.SPADES, Rank.King, getAbsoluteFilePath("KingSpades.png"), "Ks");
		Card Kss = new Card(Suit.SPADES, Rank.King, getAbsoluteFilePath("KingSpadesSmall.png"), "Ks small");

		Card Kc = new Card(Suit.CLUBS, Rank.King, getAbsoluteFilePath("KingClubs.png"), "Kc");
		Card Kh = new Card(Suit.HEARTS, Rank.King, getAbsoluteFilePath("KingHearts.png"), "Kh");
		
		//Random images for negative testing(they are not blank)
		Card blank1 = new Card("Blank 1", getAbsoluteFilePath("Blank1.png"));
		Card blank2 = new Card("Blank 2", getAbsoluteFilePath("Blank2.png"));
		
		deck.add(aceDiamonds);
		deck.add(aceSpades);
		deck.add(blank1);
		deck.add(blank2);
		
		deck.add(Kd);
		deck.add(Ks);
		deck.add(Kss);
		deck.add(Kc);
		deck.add(Kh);
	}
	
	public static boolean isCardInImage(Card card, Mat image)
	{
		String cardFilePath = card.myFilePath;
		Mat cardImage = Highgui.imread(cardFilePath);
		
		int result_cols = image.cols() - cardImage.cols() + 1;
		int result_rows = image.rows() - cardImage.rows() + 1;
		
		Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
		Imgproc.matchTemplate(image, cardImage, result, Imgproc.TM_SQDIFF );
		MinMaxLocResult mmr = Core.minMaxLoc(result);
		
		//TODO test if 1000.0 is the correct threshold
		return (mmr.minVal < 1000.0d);
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			initCards();

			Mat AdAs = Highgui.imread(getAbsoluteFilePath("AcesHand.png"));
			
			for (Card card : deck)
			{
				if (isCardInImage(card, AdAs))
				{
					System.out.println("*" + card.name + " is in AdAs");
				} else
				{
					System.out.println(card.name + " is NOT in AdAs");

				}
			}
			
			System.out.println("");
			
			Mat KhKs = Highgui.imread(getAbsoluteFilePath("KhKs.png"));
			
			for (Card card : deck)
			{
				if (isCardInImage(card, KhKs))
				{
					System.out.println("*" + card.name + " is in KhKs");
				} else
				{
					System.out.println(card.name + " is NOT in KhKs");

				}
			}
			
			
			//			
//			Robot robot = new Robot(getGraphicsDevice());
//			
//			//907,596
//			//1006,643
//			
//			Rectangle rect = new Rectangle(907, 596, 100, 50);
//			
//			BufferedImage image = robot.createScreenCapture(rect);
//			
//			File outFile = new File("C:/eclipse/My Junk/test.jpg");
//			ImageIO.write(image, "jpg", outFile);
			
		} catch (Throwable t)
		{
			System.out.println("Error: " + t + ", " + t.getMessage());
			System.out.println(t.getStackTrace());
		}
	}

	private static GraphicsDevice getGraphicsDevice()
	{
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();

		return gs[0];
	}
	
	// Convert image to Mat
	public Mat matify(BufferedImage im)
	{
		// Convert bufferedimage to byte array
		byte[] pixels = ((DataBufferByte) im.getRaster().getDataBuffer())
				.getData();

		// Create a Matrix the same size of image
		Mat image = new Mat(im.getHeight(), im.getWidth(), CvType.CV_8UC3);
		// Fill Matrix with image values
		image.put(0, 0, pixels);

		return image;
	}
	
	private static String getAbsoluteFilePath(String fileName)
	{
		String absPath = JavaRobot.class.getResource("/resources/" + fileName).getFile();
		File file = new File(absPath);
		
		return file.getAbsolutePath();
	}
}