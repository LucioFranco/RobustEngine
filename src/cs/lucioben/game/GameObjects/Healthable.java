/** 
 * The interface for a healable object. 
 * 
 * @author Lucio Franco
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects;

public interface Healthable {
	/**
	 * Gets the height of the healable
	 * @return the height
	 */
	public int getHeight();
	
	/**
	 * Gets the health of the healable
	 * @return the health
	 */
	public int getHealth();
}
