package cs.lucioben.game.base;

import java.io.File;
import java.io.FileInputStream;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public abstract class GameObject implements Cloneable {
	private int width;
	private int height;
	private int boundingBoxWidth; 
	private int boundingBoxHeight;
	private Vector2f position;
	private Texture texture;
	private float rotation;
	private GameObjectType type = GameObjectType.NO_TYPE;
	private final static String DEFAULT_PATH = "res/images/defaultTexture.png";
	
	public GameObject() {
		this(0,0,0,0,0,new Vector2f(0,0), DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, Vector2f position) {
		this(width, height, width, height, 0, position, DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, float rotation, Vector2f position) {
		this(width, height, width, height, rotation, position, DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, float rotation, Vector2f position, String path) {
		this(width, height, width, height, rotation, position, path);
	}
	
	public GameObject(int width, int height, int boundingBoxWidth, int boundingBoxHeight, float rotation, Vector2f position) {
		this(width, height, boundingBoxWidth, boundingBoxHeight, rotation, position, DEFAULT_PATH);
	}
	
	public GameObject(int width, int height, int boundingBoxWidth, int boundingBoxHeight, float rotation, Vector2f position, String texturePath) {
		this.width = width;
		this.height = height;
		this.boundingBoxWidth = boundingBoxWidth; 
		this.boundingBoxHeight = boundingBoxHeight;
		this.position = position;
		this.rotation = rotation;
		this.texture = loadTexture(texturePath);
	}
	
	public static Texture loadTexture(String path){
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
	public void setWidth(int width){
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setTexture(String path){
		texture = loadTexture(path);
	}
	public Texture getTexture(){
		return texture; 
	}
	public int getBoundingBoxWidth() {
		return boundingBoxWidth;
	}
	public void setBoundingBoxWidth(int boundingBoxWidth) {
		this.boundingBoxWidth = boundingBoxWidth;
	}
	public int getBoundingBoxHeight() {
		return boundingBoxHeight;
	}
	public void setBoundingBoxHeight(int boundingBoxHeight) {
		this.boundingBoxHeight = boundingBoxHeight;
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
	
	public GameObject clone() {
		try {
			return (GameObject) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public abstract void update();
	public abstract void draw();
}
