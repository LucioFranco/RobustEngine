/** 
 * An empty object
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects.base;

import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.base.GameObject;

public abstract class EmptyObject extends GameObject {

	/**
	 * An empty constructor that sets everything to 0.
	 */
	public EmptyObject() {
		super(0, 0, 0, new Vector2f(0,0));
	}

	/**
	 * An abstract update method
	 */
	public abstract void update();

	/**
	 * Draws nothing
	 */
	@Override
	public void draw() {
		return;
	}

}
