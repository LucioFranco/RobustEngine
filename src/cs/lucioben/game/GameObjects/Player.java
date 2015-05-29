package cs.lucioben.game.GameObjects;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.base.GameObject;

public class Player extends GameObject {
	private boolean isColliding = false;
	private Vector2f previousPosition;
	
	public Player(int i, int j, float rotation, Vector2f position) {
		super(i, j, rotation, position);
	}
	
	public Player(int i, int j, float rotation, Vector2f position, String texture) {
		super(i, j, rotation, position, texture);
	}

	@Override
	public void update() {	
		previousPosition = new Vector2f(this.getPosition());
		
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.setPositionY(this.getPosition().y - 10);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.setPositionX(this.getPosition().x - 10);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.setPositionY(this.getPosition().y + 10);
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.setPositionX(this.getPosition().x + 10);
		}
	}
		
	public void detectCollision(ArrayList<GameObject> GameObjectList){		
		for(GameObject GameObj : GameObjectList) {	
			//If it is not a player or HUD object
			if(GameObj.getType() == 1){
				if( this.getPosition().x < GameObj.getPosition().x + GameObj.getWidth() &&
					this.getPosition().x + this.getWidth() > GameObj.getPosition().x &&
					this.getPosition().y < GameObj.getPosition().y + GameObj.getHeight() &&
					this.getPosition().y + this.getHeight() > GameObj.getPosition().y){
					
					this.setPosition(previousPosition);
				}
			}
		}
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
	
	public boolean isColliding(){
		return isColliding;
	}
	
	public void setColliding(boolean t){
		isColliding = t;
	}
}