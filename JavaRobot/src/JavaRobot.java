import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class JavaRobot
{
	public static void main(String[] args)
	{
		try
		{
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			Mat img = Highgui.imread("C:/eclipse/My Junk/test.jpg");
			Mat aceDiamonds = Highgui.imread("C:/eclipse/My Images/AceDiamonds.png");
			Mat blank1 = Highgui.imread("C:/eclipse/My Images/Blank.png");
			Mat aceSpades = Highgui.imread("C:/eclipse/My Images/AceSpades.png");
			Mat blank2 = Highgui.imread("C:/eclipse/My Images/Blank2.png");

			// / Create the result matrix
			int result_cols = img.cols() - aceDiamonds.cols() + 1;
			int result_rows = img.rows() - aceDiamonds.rows() + 1;

			Mat result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			Imgproc.matchTemplate(img, aceDiamonds, result, Imgproc.TM_SQDIFF );
			MinMaxLocResult mmr = Core.minMaxLoc(result);
			System.out.println("aceDiamonds is max val: " + mmr.maxVal + ", min val: "
					+ mmr.minVal + ", max loc: " + mmr.maxLoc + ", min loc: "
					+ mmr.minLoc);
			
			result_cols = img.cols() - aceSpades.cols() + 1;
			result_rows = img.rows() - aceSpades.rows() + 1;
			result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			Imgproc.matchTemplate(img, aceSpades, result, Imgproc.TM_SQDIFF );
			mmr = Core.minMaxLoc(result);
			System.out.println("aceSpades is max val: " + mmr.maxVal + ", min val: "
					+ mmr.minVal + ", max loc: " + mmr.maxLoc + ", min loc: "
					+ mmr.minLoc);
			
			result_cols = img.cols() - blank1.cols() + 1;
			result_rows = img.rows() - blank1.rows() + 1;
			result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			Imgproc.matchTemplate(img, blank1, result, Imgproc.TM_SQDIFF );
			mmr = Core.minMaxLoc(result);
			System.out.println("blank 1 is max val: " + mmr.maxVal + ", min val: "
					+ mmr.minVal + ", max loc: " + mmr.maxLoc + ", min loc: "
					+ mmr.minLoc);
			
			result_cols = img.cols() - blank2.cols() + 1;
			result_rows = img.rows() - blank2.rows() + 1;
			result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
			Imgproc.matchTemplate(img, blank2, result, Imgproc.TM_SQDIFF );
			mmr = Core.minMaxLoc(result);
			System.out.println("blank 2 is max val: " + mmr.maxVal + ", min val: "
					+ mmr.minVal + ", max loc: " + mmr.maxLoc + ", min loc: "
					+ mmr.minLoc);
			
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
	
//	private static boolean isCardInHand(Card card, MinMaxLocResult mmr)
//	{
//		//mmr.minVal
//	}
}