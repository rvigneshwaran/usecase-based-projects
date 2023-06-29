import java.util.Timer;


public class Executer {

	public static void main(String[] args) {
      Timer timer = new Timer();
	  timer.schedule(new ScreenCapturer(), 0, 5000);
	}

}
