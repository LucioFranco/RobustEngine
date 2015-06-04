/** 
 * The primary application class. This starts the game.
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.base;

import org.lwjgl.opengl.DisplayMode;

import cs.lucioben.game.scenes.SecondScene;
import cs.lucioben.game.scenes.StartScene;
import cs.lucioben.game.scenes.ThirdScene;
import cs.lucioben.game.scenes.TitleScene;
import cs.lucioben.game.scenes.WinScene;

public class Application {
	
	/**
	 * The main class for the game. 
	 * @param args
	 */
	public static void main(String[] args) {
		Scene[] scenes = {
					new TitleScene(),
					new StartScene(),
					new SecondScene(),
					new ThirdScene(),
					new WinScene()
				};
		Game game = Game.getContext();
		Game.setDisplayMode(new DisplayMode(900, 600));
		game.start(scenes);
	}
}