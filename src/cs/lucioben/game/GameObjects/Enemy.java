package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Enemy extends GameObject{
	private final float SPEED = 2; 
	private static final int WIDTH = 96;
	private static final int HEIGHT = 96;
	private float health = 100;
	private Vector2f velocity = new Vector2f(0,0);
	private Player player; 
	
	public Enemy(Vector2f startingPosition, Player player){
		super(WIDTH, HEIGHT, 0, startingPosition);
		this.setType(GameObjectType.ENEMY);
		this.player = player;
	}
	
	@Override
	public void update() {				
		float tx = player.getPosition().x - this.getPosition().x;
		float ty = player.getPosition().y - this.getPosition().y;
		float dist = (float)Math.sqrt(tx * tx + ty * ty);
		velocity.x = (tx/dist) * SPEED;
		velocity.y = (ty/dist) * SPEED;
		
		this.setRotation((float)(Math.atan2(player.getPosition().y - this.getPosition().y, player.getPosition().x - this.getPosition().x) * (180/Math.PI)));
		
		if(health <= 0){
			Game.getCurrentScene().remove(this);
		}
	}
	
	public void takeDamage(float amount){
		health -= amount;
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
