package cs.lucioben.game.base;

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
	private static ArrayList<GameObject> GameObjectList;
		
	public State state;
	
	private Game(int width, int height) {
		try{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.create();
			Display.setVSyncEnabled(true);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void start(Scene[] sceneList) {
		try {
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
		GL11.glOrtho(0, getScreenWidth(), screenHeight, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		if(!this.state.hasNext()) {
			System.err.println("You have not passed any scenes");
		}
		
		if(this.state.hasNext()){
			GameObjectList = this.state.next().getSceneObjects();
		}
		else{
			 GameObjectList = new ArrayList<GameObject>();
		}
		
		while(!Display.isCloseRequested()){
			fpsCounter.updateFPS();
			
			GameObjectList = state.getCurrentScene().getSceneObjects();
					    
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
			
			for(GameObject GameObj : GameObjectList) {		
				//Set the color to white by default
				GL11.glColor3f(255, 255, 255);

				GameObj.update();

				GL11.glLoadIdentity();
				GL11.glPushMatrix();

				GL11.glTranslatef(GameObj.getPosition().x, GameObj.getPosition().y, 0);
				GL11.glRotatef(GameObj.getRotation(), 0, 0, 1);
				GL11.glTranslatef(-GameObj.getPosition().x, -GameObj.getPosition().y, 0);
				
				GameObj.getTexture().bind();
				GameObj.draw();
				
				GL11.glPopMatrix();
			}
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static Game getContext() {
		if(Game.context == null) {
			Game.context = new Game(Game.getScreenWidth(), Game.screenHeight);
			return Game.context;
		}else {
			return Game.context;
		}
	}

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}
}