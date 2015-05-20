package cs.lucioben.game.base;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Game {
	
	private static int screenWidth = 800;
	private static int screenHeight = 600;
	private static String title = "openGl Game";
	private static Game context;
	private static FPSCounter fpsCounter = FPSCounter.getInstance(); 
	
	public State state;
	
	private Game(int width, int height) {
		try{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void start(Scene[] sceneList) {
		try {
			Display.create();
			this.state = new State(sceneList);
			gameLoop();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void gameLoop() {		
		//Game loop
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, screenWidth, screenHeight, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		if(!this.state.hasNext()) {
			System.err.println("You have not passed any scenes");
		}
		ArrayList<GameObject> GameObjectList = this.state.hasNext() ? this.state.next().getSceneObjects() : new ArrayList<GameObject>();
		while(!Display.isCloseRequested()){
			fpsCounter.updateFPS();
			
			GameObjectList = state.getCurrentScene().getSceneObjects();
			System.out.println(this.state.getCurrentScene().toString());
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			for(GameObject GameObj : GameObjectList) {
				GameObj.update();

				/*
				 *TODO Do this command for each game object.
		  		glBindTexture(GL_TEXTURE_2D, redTex);
				*/
				
				GL11.glBegin(GL11.GL_QUADS);
					GameObj.draw();
				GL11.glEnd();
			}
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static Game getContext() {
		if(Game.context == null) {
			Game.context = new Game(Game.screenWidth, Game.screenHeight);
			return Game.context;
		}else {
			return Game.context;
		}
	}

	private int loadTexture(String textureLocation){
		int textureID = glGenTextures();
		try{
			InputStream in = new FileInputStream(textureLocation);
			PNGDecoder decoder = new PNGDecoder(in);
			
			ByteBuffer buf = ByteBuffer.allocateDirect(4*decoder.getWidth()*decoder.getHeight());
			decoder.decode(buf, decoder.getWidth()*4, PNGDecoder.Format.RGBA);
			buf.flip();
 
			glBindTexture(GL_TEXTURE_2D, textureID);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, decoder.getWidth(), decoder.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
			in.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		return textureID;
	}
}