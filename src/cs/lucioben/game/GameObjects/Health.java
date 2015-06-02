package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Health extends GameObject {
	private int value = 100;
	private float maxValue, scale; 
	private Player player;
	
	public Health(int width, int height, Vector2f pos, String path, Player player) {
		super(width, height, 0, pos, path);
		super.setType(GameObjectType.TEXT);
		this.player = player; 
		this.maxValue = player.getHealth();
		scale = (this.getWidth() / maxValue);
	}

	@Override
	public void update() {
		value = player.getHealth();
		
		this.setWidth((int)scale * value);
				
		return;
	}

	@Override
	public void draw() {	
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