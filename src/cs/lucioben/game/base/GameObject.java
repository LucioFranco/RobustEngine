package cs.lucioben.game.base;

import org.lwjgl.util.vector.Vector2f;

public abstract class GameObject {
	public int width;
	public int height;
	public Vector2f position;
	public float rotation;
	
	public GameObject() {
		this.width = 0;
		this.height = 0;
		this.position = new Vector2f(0,0);
		this.rotation = 0;
	}
	
	public GameObject(int width, int height, float rotation, Vector2f position) {
		this.width = width;
		this.height = height;
		this.position = position;
		this.rotation = rotation;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}
	public float getRotation(){
		return rotation;
	}
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public abstract void update();
	public abstract void draw();
}
