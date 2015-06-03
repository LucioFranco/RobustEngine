/** 
 * The abstract class for a general game object. 
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

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
	private String texturePath;
	private final static String DEFAULT_PATH = "res/images/defaultTexture.png";
	
	/**
	 * Empty constructor 
	 */
	public GameObject() {
		this(0,0,0,0,0,new Vector2f(0,0), DEFAULT_PATH);
	}
	

	/**
	 * Another constructor 
	 */
	public GameObject(int width, int height, Vector2f position) {
		this(width, height, width, height, 0, position, DEFAULT_PATH);
	}
	
	/**
	 * Another constructor 
	 */
	public GameObject(int width, int height, float rotation, Vector2f position) {
		this(width, height, width, height, rotation, position, DEFAULT_PATH);
	}
	
	/**
	 * Another constructor 
	 */
	public GameObject(int width, int height, float rotation, Vector2f position, String path) {
		this(width, height, width, height, rotation, position, path);
	}
	
	/**
	 * Another constructor 
	 */
	public GameObject(int width, int height, int boundingBoxWidth, int boundingBoxHeight, float rotation, Vector2f position) {
		this(width, height, boundingBoxWidth, boundingBoxHeight, rotation, position, DEFAULT_PATH);
	}
	
	/**
	 * Another constructor, with everything. 
	 */
	public GameObject(int width, int height, int boundingBoxWidth, int boundingBoxHeight, float rotation, Vector2f position, String texturePath) {
		this.width = width;
		this.height = height;
		this.boundingBoxWidth = boundingBoxWidth; 
		this.boundingBoxHeight = boundingBoxHeight;
		this.position = position;
		this.rotation = rotation;
		this.texturePath = texturePath;
		this.texture = GameObject.loadTexture(texturePath);
	}
	
	/**
	 * This method creates a texture object from a file location. 
	 * @param path The path of the file location
	 * @return The Texture generated. 
	 */
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
	
	/**
	 * This method creates a texture object from an object 
	 * @param obj The object with the texture path.
	 * @return The Texture generated. 
	 */
	public static Texture loadTexture(GameObject obj){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File(obj.getTexturePath())));
		}
		catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		return null;
	}
	
	/**
	 * Gets texture path
	 * @return The path of the texture.
	 */
	public String getTexturePath() {
		return this.texturePath;
	}
	
	/**
	 * Sets texture path
	 * @param path The path of the texture. 
	 */
	public void setTexture(String path){
		texture = loadTexture(path);
	}
	
	/**
	 * Gets texture
	 * @return The texture.
	 */
	public Texture getTexture(){
		return texture; 
	}
	
	/**
	 * Gets position
	 * @return The position.
	 */
	public Vector2f getPosition() {
		return position;
	}
	
	/**
	 * Sets the position
	 * @param position The position
	 */
	public void setPosition(Vector2f position){
		this.position = position;
	}
	
	/**
	 * Gets texture path
	 * @return The path of the texture.
	 */
	public float getRotation(){
		return rotation;
	}
	
	
	/**
	 * Sets the rotation
	 * @param rotation The rotation
	 */
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	
	/**
	 * Gets the width
	 * @return The width
	 */
	public int getWidth() {
		return width;
	}
	
	
	/**
	 * Set width
	 * @param width The width
	 */
	public void setWidth(int width){
		this.width = width;
	}
	
	
	/**
	 * Gets height
	 * @return The height
	 */
	public int getHeight() {
		return height;
	}
	
	
	/**
	 * Gets bounding box width
	 * @return The bounding box width
	 */
	public int getBoundingBoxWidth() {
		return boundingBoxWidth;
	}
	
	/**
	 * Sets bounding box width
	 * @param boundingBoxWidth The bounding box width
	 */
	public void setBoundingBoxWidth(int boundingBoxWidth) {
		this.boundingBoxWidth = boundingBoxWidth;
	}
	
	/**
	 * Gets bounding box height
	 * @return The bounding box height
	 */
	public int getBoundingBoxHeight() {
		return boundingBoxHeight;
	}
	
	/**
	 * Sets bounding box height
	 * @param boundingBoxWidth The bounding box height
	 */
	public void setBoundingBoxHeight(int boundingBoxHeight) {
		this.boundingBoxHeight = boundingBoxHeight;
	}
	
	/**
	 * Sets the type
	 * @param t The Game object type. 
	 */
	public void setType(GameObjectType t){
		type = t;
	}
	
	/**
	 * Gets the type
	 * @return t The Game object type. 
	 */
	public GameObjectType getType(){
		return type;
	}
	
	/**
	 * Will not work with player
	 * @param cameraOffset The camera's offset
	 * @return the screen position.
	 */
	public Vector2f getScreenPosition(Vector2f cameraOffset){
		return new Vector2f(this.getPosition().x - cameraOffset.x, this.getPosition().y - cameraOffset.y);
	}
	
	
	/**
	 * @return a clone of this object
	 */
	public GameObject clone() {
		try {
			return (GameObject) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Update method, every frame.
	 */
	public abstract void update();
	
	
	/**
	 * Draw method, every frame.
	 */
	public abstract void draw();
}
