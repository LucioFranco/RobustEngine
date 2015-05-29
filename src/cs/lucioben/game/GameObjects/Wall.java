package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class Wall extends GameObject {	
	public Wall(int i, int j, float rotation, Vector2f position, String texture) {
		super(i, j, rotation, position, texture);
	}

	@Override
	public void update() {
	}
	
	@Override
	public void draw() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0); 
		GL11.glVertex2f(0,0);
		
		GL11.glTexCoord2f(0,1); 
		GL11.glVertex2f(0, this.getHeight());

		GL11.glTexCoord2f(1,1); 
		GL11.glVertex2f(this.getWidth(), this.getHeight());
		
		GL11.glTexCoord2f(1,0); 
		GL11.glVertex2f(this.getWidth(), 0);
		GL11.glEnd();
	}
	
	public Vector2f getScreenPosition(Vector2f cameraOffset){
		return new Vector2f(this.getPosition().x - cameraOffset.x, this.getPosition().y - cameraOffset.y);
	}
}