package cs.lucioben.game.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import cs.lucioben.game.base.PNGDecoder.Format;

public abstract class GameObject {
	private int width;
	private int height;
	private Vector2f position;
	private Texture texture;
	private float rotation;
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
	public Texture getTexture(){
		return texture; 
	}
	
	public abstract void update();
	public abstract void draw();
}
