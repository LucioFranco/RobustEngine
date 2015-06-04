/** 
 * A generic tile on the map
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class MapTile extends GameObject {
	
	/**
	 * A constructor for the map tile object. 
	 * @param width the width of the tile
	 * @param height the height of the tile
	 * @param texturePath the location of the texture for the tile
	 * @param type the object type of the tile
	 */
	public MapTile(int width, int height, String texturePath, GameObjectType type) {
		super(width, height, 0, new Vector2f(0, 0), texturePath);
		this.setType(type);
	}
	
	/**
	 * Updates the map tile (currently does nothing)
	 */
	@Override
	public void update() {
		return;
	}
	
	/**
	 * Draws the tile
	 */
	@Override
	public void draw() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0); 
		GL11.glVertex2f(-this.getWidth()/2, -this.getHeight()/2);
		
		GL11.glTexCoord2f(0,1); 
		GL11.glVertex2f(-this.getWidth()/2, this.getHeight()/2);

		GL11.glTexCoord2f(1,1); 
		GL11.glVertex2f(this.getWidth()/2, this.getHeight()/2);
		
		GL11.glTexCoord2f(1,0); 
		GL11.glVertex2f(this.getWidth()/2, -this.getHeight()/2);
		GL11.glEnd();
	}
}
