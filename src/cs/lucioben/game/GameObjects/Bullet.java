package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;

public class Bullet extends GameObject{
	private final float SPEED = 75f; 
	private static final int WIDTH = 4;
	private static final int HEIGHT = 10;
	private Vector2f velocity;
	
	public Bullet(Vector2f startingPosition, float rotation){
		super(WIDTH, HEIGHT, 0, startingPosition);

		this.setRotation(-(float)(Math.atan2(Mouse.getY() - Game.getScreenHeight()/2, Mouse.getX() - Game.getScreenWidth()/2) * (180/Math.PI)));
		velocity = new Vector2f((float)Math.cos(Math.toRadians(rotation)), (float)Math.sin(Math.toRadians(rotation))); 
	}
	
	@Override
	public void update() {
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
