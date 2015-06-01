package cs.lucioben.game.base;

import java.io.File;
import java.io.FileInputStream;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public abstract class GameObject {
	private int width;
	private int height;
	private Vector2f position;
	private Texture texture;
	private float rotation;
	private GameObjectType type = GameObjectType.NO_TYPE;
	private final static String DEFAULT_PATH = "res/images/defaultTexture.png";
	
	public GameObject() {
		this(0,0,0,new Vector2f(0,0), DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, float rotation, Vector2f position) {
		this(width, height, rotation, position, DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, float rotation, Vector2f position, String texturePath) {
		this.width = width;
		this.height = height;
		this.position = position;
		this.rotation = rotation;
		this.texture = loadTexture(texturePath);
	}
	
	private Texture loadTexture(String path){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File(path)));
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		return null;
	}
	
	public Vector2f getPosition() {
		return position;
	}
	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
	}
	public void setPosition(Vector2f position){
		this.position = position;
	}
	public void setPositionY(float y){
		this.position.y = y;
	}
	public void setPositionX(float x){
		this.position.x = x;
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
	public Texture getTexture(){
		return texture; 
	}
	
	public void setType(GameObjectType t){
		type = t;
	}
	
	public GameObjectType getType(){
		return type;
	}
	
	/**
	 * Will not work with player
	 * @param cameraOffset
	 * @return
	 */
	public Vector2f getScreenPosition(Vector2f cameraOffset){
		return new Vector2f(this.getPosition().x - cameraOffset.x, this.getPosition().y - cameraOffset.y);
	}
	
	/*
	 * Types:
	 * 0 - Player
	 * 1 - Wall - Collision
	 * 2 - HUD/Text
	 * 3 - Wall - No collision
	 * 4 - Bullet
	 */
	
	public abstract void update();
	public abstract void draw();
}
