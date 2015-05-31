package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class Floor extends GameObject {	
	private static final int WIDTH = 96;
	private static final int HEIGHT = 96;
	
	public Floor(Vector2f position){
		super(WIDTH, HEIGHT, 0, position, "res/images/floor.png");
	}
	
	public static int getTileWidth(){
		return WIDTH;
	}
	
	public static int getTileHeight(){
		return HEIGHT;
	}

	@Override
	public void update() {
		return;
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
}
