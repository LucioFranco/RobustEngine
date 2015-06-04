/** 
 * The last scene displayed
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.Scene;

public class WinScene extends Scene {
	
	/**
	 * Sets up the scene
	 */
	@Override
	public void setup() {
		this.add(new TextObject("You WON!", new Vector2f(Game.getScreenWidth() / 2 - 165, Game.getScreenHeight() / 2), Color.white, 46f));
		this.add(new TextObject("Press Space to Quit", new Vector2f(Game.getScreenWidth() / 2 - 170, Game.getScreenHeight() / 2 + 50), Color.white, 26f));
		this.add(new SceneChanger());
	}

}
