/** 
 * This is an FPS counter
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

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
	
	/**
	 * @return the instance of this object
	 */
	public static FPSCounter getInstance(){
		if(instance == null){
			instance = new FPSCounter();
		}
		
		return instance;
	}
	
	private int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
 
	    return delta;
	}

	private long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
 
	/**
	 * Updates the FPS count
	 */
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