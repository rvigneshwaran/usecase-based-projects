import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class ScreenCapturer extends TimerTask {
	
	/** The _log location. */
	private static String _logLocation = "C:\\ScreenCastLogHistory\\";
	
	/**
	 * Creates the directory.
	 */
	private static void createDirectory(){
	  new File("C:\\ScreenCastLogHistory").mkdir();
	}
	
	/**
	 * Gets the current time with screen shot.
	 *
	 * @return the current time with screen shot
	 */
	private static void getCurrentTimeWithScreenShot(){
	  createDirectory();
	  try {
	    Robot robot = new Robot();
		String format = "png";
		String fileName = new SimpleDateFormat("E dd MMM yyyy HH mm ss z").format(new Date());
		String customFileName = fileName + "."+ format;
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, format, new File(_logLocation+customFileName));
	  } catch (AWTException exception) {
	    System.err.println(exception);
	  } catch( IOException exception){
	    System.err.println(exception);
	  }  
	}

	@Override
	public void run() {
	  getCurrentTimeWithScreenShot();
	  String timeFrame = new SimpleDateFormat("E dd MMM yyyy HH mm ss z").format(new Date());
	  System.out.println("Saving the screen shot at :: "+timeFrame);
	}

}
