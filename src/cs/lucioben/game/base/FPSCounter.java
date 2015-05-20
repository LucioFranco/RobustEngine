package cs.lucioben.game.base;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class FPSCounter {
	private static FPSCounter instance = null;
	private static long lastFrame = 0;
	private static int fps = 0;
	private static long lastFPS = 0;
	
	private FPSCounter(){ 
		lastFPS = getTime();
	}
	
	public static FPSCounter getInstance(){
		if(instance == null){
			instance = new FPSCounter();
		}
		
		return instance;
	}
	
	/** Gets how many milliseconds have passed since the last frame. */
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
 
	    return delta;
	}

	/** Gets the current system time. */
	public long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
 
	/** Updates the FPS count */
	public void updateFPS() {
		//TODO Change this to display on screen.
		
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
}