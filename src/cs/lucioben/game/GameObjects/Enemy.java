package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;

public class Enemy extends GameObject{
	private final float SPEED = 10f; 
	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;
	private Vector2f velocity;
	
	public Enemy(Vector2f startingPosition){
		super(WIDTH, HEIGHT, 0, startingPosition);
	}
	
	@Override
	public void update() {		
		velocity = new Vector2f((float)Math.cos(Math.toRadians(this.getRotation())), (float)Math.sin(Math.toRadians(this.getRotation()))); 
		
		this.setRotation(-(float)(Math.atan2(Mouse.getY() - Game.getScreenHeight()/2, Mouse.getX() - Game.getScreenWidth()/2) * (180/Math.PI)));
		this.setPosition(new Vector2f(this.getPosition().x + velocity.x * SPEED, this.getPosition().y + velocity.y * SPEED));

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
