/** 
 * A variation of map tile that allows multiple layers of textures. 
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class MutliLayerObject extends GameObject {
	private GameObject obj;
	private MapTile tile;
	
	/**
	 * The constructor for the MultiLayerObject
	 * @param width the width of the tile
	 * @param height the height of the tile
	 * @param obj the object that will overlay the tile
	 * @param tile the tile that is under the object
	 */
	public MutliLayerObject(int width, int height, GameObject obj, MapTile tile) {
		super(96, 96, 0, new Vector2f(0, 0));
		this.obj = obj;
		this.tile = tile;
	}

	/**
	 * Updates the tile and object
	 */
	@Override
	public void update() {
		obj.update();
		tile.update();
	}

	/**
	 * Draws the tile underneath the object. 
	 */
	@Override
	public void draw() {
		tile.setPosition(this.getPosition());
		GL11.glRotatef(tile.getRotation(), 0, 0, 1);
		tile.getTexture().bind();
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
		
		obj.setPosition(this.getPosition());
		GL11.glRotatef(obj.getRotation(), 0, 0, 1);
		obj.getTexture().bind();
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
