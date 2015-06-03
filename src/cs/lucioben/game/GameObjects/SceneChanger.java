/** 
 * An object that changes the scene when the space bar is pressed
 * 
 * @author Lucio Franco
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;
import cs.lucioben.game.GameObjects.base.EmptyObject;
import cs.lucioben.game.base.Game;

public class SceneChanger extends EmptyObject {

	/**
	 * Updates the scene changer, changes scene when space bar is pressed. 
	 */
	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			Game.getContext().state.next();
		}
	}
}
