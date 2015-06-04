/** 
 * The interface for a healthable object. 
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects;

public interface Healthable {
	/**
	 * Gets the height of the healthable
	 * @return the height
	 */
	public int getHeight();
	
	/**
	 * Gets the health of the healthable
	 * @return the health
	 */
	public int getHealth();
}
