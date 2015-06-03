/** 
 * The floor tile
 * 
 * @author Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class Floor extends GameObject {	
	private static final int WIDTH = 96;
	private static final int HEIGHT = 96;
	
	/**
	 * The constructor for the floor 
	 * @param position the position of the tile 
	 */
	public Floor(Vector2f position){
		super(WIDTH, HEIGHT, 0, position, "res/images/floor.png");
	}
	
	/**
	 * Gets the tile width
	 * @return the tile width
	 */
	public static int getTileWidth(){
		return WIDTH;
	}
	
	/**
	 * Gets the tile height
	 * @return the tile height
	 */
	public static int getTileHeight(){
		return HEIGHT;
	}

	/**
	 * Updates the floor.
	 */
	@Override
	public void update() {
		return;
	}
	
	/**
	 * Draws the floor. 
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
