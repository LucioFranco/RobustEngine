package cs.lucioben.game.GameObjects.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class MapTile extends GameObject {
	public MapTile(int width, int height, String texturePath, GameObjectType type) {
		super(width, height, 0, new Vector2f(0, 0), texturePath);
		this.setType(type);
	}
	
	@Override
	public void update() {
		return;
	}
	
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
