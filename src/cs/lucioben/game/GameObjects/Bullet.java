package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Bullet extends GameObject{
	private final float SPEED = 75f; 
	private static final int WIDTH = 4;
	private static final int HEIGHT = 10;
	private Vector2f velocity;
	private boolean alive = true; 
	private float damage;
	
	public Bullet(Vector2f startingPosition, float rotation, float damage){
		super(WIDTH, HEIGHT, 0, startingPosition);

		this.setTexture("res/images/bullet.png");
		this.setRotation(90 + -(float)(Math.atan2(Mouse.getY() - Game.getScreenHeight()/2, Mouse.getX() - Game.getScreenWidth()/2) * (180/Math.PI)));
		this.setType(GameObjectType.TEMP_OBJECT);
		velocity = new Vector2f((float)Math.cos(Math.toRadians(rotation)), (float)Math.sin(Math.toRadians(rotation))); 
		this.damage = damage; 
	}
	
	@Override
	public void update() {
		this.setPosition(velocity, SPEED);
		
		if(!alive){
			Game.getCurrentScene().remove(this);
		}
	}
	
	public float getDamage(){
		return damage;
	}
	
	public void setPosition(Vector2f direction, float distance){	
		Vector2f futurePosition = this.getPosition();
		Vector2f previousPosition = this.getPosition();
		
		while(distance > 0){
			previousPosition = futurePosition;
			futurePosition = new Vector2f(futurePosition.x + direction.x, futurePosition.y + direction.y);
			
			boolean collision = false;
			for(GameObject GameObj : Game.getCurrentScene().getSceneObjects()) {	
				if(GameObj.getType().equals(GameObjectType.COLLISON) || GameObj.getType().equals(GameObjectType.ENEMY)){
					if( futurePosition.x - this.getWidth()/2 < GameObj.getPosition().x + GameObj.getWidth()/2 &&
						futurePosition.x + this.getWidth()/2 > GameObj.getPosition().x - GameObj.getWidth()/2 &&
						futurePosition.y - this.getHeight()/2 < GameObj.getPosition().y + GameObj.getHeight()/2 &&
						futurePosition.y + this.getHeight()/2 > GameObj.getPosition().y - GameObj.getHeight()/2){
						
						collision = true;
						
						if(GameObj.getType().equals(GameObjectType.ENEMY)){
							Enemy e = (Enemy)GameObj;
							e.takeDamage(this.getDamage());
						}
					}
				}
			}
			
			if(collision){
				alive = false;
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
