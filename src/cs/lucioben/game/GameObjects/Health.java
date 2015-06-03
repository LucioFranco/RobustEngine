/** 
 * The health bar
 * 
 * @author Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Health extends GameObject {
	private int value = 100;
	private float maxValue, scale; 
	private Healthable obj;
	private static int width = 100;
	private static int height = 10;
	
	/**
	 * The constructor the the health bar
	 * @param path the path of the texture file
	 * @param obj the object that is healable 
	 */
	public Health(String path, Healthable obj) {
		super(width, height, 0, new Vector2f(0, 0), path);
		super.setType(GameObjectType.TEXT);
		this.obj = obj; 
		this.maxValue = obj.getHealth();
		scale = (this.getWidth() / maxValue);
	}

	/**
	 * Updates the health bar
	 */
	@Override
	public void update() {
		value = obj.getHealth();
		
		this.setWidth((int)scale * value);
		this.setPosition(new Vector2f(Game.getScreenWidth()/2, Game.getScreenHeight()/2 - ((GameObject)obj).getHeight() / 2));
				
		return;
	}

	/**
	 * Draws the health bar
	 */
	@Override
	public void draw() {
		this.getTexture().bind();
	    GL11.glRotatef(this.getRotation(), 0, 0, 1);
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