package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;

public class Player extends GameObject {
	private final int SPEED = 10;
	private boolean isColliding = false;
	
	public Player(int i, int j, float rotation, Vector2f position) {
		super(i, j, rotation, position);
	}
	
	public Player(int i, int j, float rotation, Vector2f position, String texture) {
		super(i, j, rotation, position, texture);
	}

	@Override
	public void update() {		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			setPosition(new Vector2f(0,-1), SPEED);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			setPosition(new Vector2f(-1,0), SPEED);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			setPosition(new Vector2f(0,1), SPEED);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			setPosition(new Vector2f(1,0), SPEED);
		}

		this.setRotation(-(float)(Math.atan2(Mouse.getY() - Game.getScreenWidth()/2, Mouse.getX() - Game.getScreenHeight()/2) * (180/Math.PI)));
	}
		
	public void setPosition(Vector2f direction, int distance){	
		Vector2f futurePosition = this.getPosition();
		Vector2f previousPosition = this.getPosition();
		
		while(distance > 0){
			previousPosition = futurePosition;
			futurePosition = new Vector2f(futurePosition.x + direction.x, futurePosition.y + direction.y);
			
			boolean collision = false;
			for(GameObject GameObj : Game.getCurrentScene().getSceneObjects()) {	
				if(GameObj.getType() == 1){
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
	
	public boolean isColliding(){
		return isColliding;
	}
	
	public void setColliding(boolean t){
		isColliding = t;
	}
}