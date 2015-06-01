package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Enemy extends GameObject{
	private final float SPEED = 2; 
	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;
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
		
		this.setRotation(-(float)(Math.atan2(player.getPosition().y - this.getPosition().y, player.getPosition().x - this.getPosition().x) * (180/Math.PI)));
		this.setPosition(velocity, SPEED);
		
		if(health <= 0){
			Game.getCurrentScene().remove(this);
		}
	}
	
	public void takeDamage(float amount){
		health -= amount;
	}
	
	public void setPosition(Vector2f direction, float distance){	
		Vector2f futurePosition = this.getPosition();
		Vector2f previousPosition = this.getPosition();
		
		while(distance > 0){
			previousPosition = futurePosition;
			futurePosition = new Vector2f(futurePosition.x + direction.x, futurePosition.y + direction.y);
			
			boolean collision = false;
			for(GameObject GameObj : Game.getCurrentScene().getSceneObjects()) {	
				if(GameObj.getType().equals(GameObjectType.COLLISON) && GameObj != this){
					if( futurePosition.x - this.getWidth()/2 < GameObj.getPosition().x + GameObj.getWidth()/2 &&
						futurePosition.x + this.getWidth()/2 > GameObj.getPosition().x - GameObj.getWidth()/2 &&
						futurePosition.y - this.getHeight()/2 < GameObj.getPosition().y + GameObj.getHeight()/2 &&
						futurePosition.y + this.getHeight()/2 > GameObj.getPosition().y - GameObj.getHeight()/2){
						
						collision = true;
					}
				}
			}
			
			if(collision){
				break;
			}
			
			distance--;
		}
		
		this.setPosition(previousPosition);
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
