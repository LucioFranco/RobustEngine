package cs.lucioben.game.base;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Game {

	private static DisplayMode displayMode = new DisplayMode(900, 600);
	private static String title = "openGl Game";
	private static Game context;
	private static FPSCounter fpsCounter = FPSCounter.getInstance();
	private static ArrayList<GameObject> GameObjectList;
	private static Vector2f cameraOffset;
	private static Vector2f screenOffset;

	public State state;

	private Game() {
		cameraOffset = new Vector2f(Game.getScreenWidth()/2, Game.getScreenHeight()/2);

		try{
			Display.setDisplayMode(displayMode);
			// Uncomment below to set resizable
			// Display.setResizable(true);
			Display.setTitle(title);
			Display.create();
			Display.setVSyncEnabled(true);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Starts the game and the game loop.
	 * @param pass an array of Scene's
	 */
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
		GL11.glOrtho(0, getScreenWidth(), getScreenHeight(), 0, 0, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		if(!this.state.hasNext()) {
			System.err.println("You have not passed any scenes");
		}

		if(this.state.hasNext()) {
			GameObjectList = this.state.next().getSceneObjects();
		}else {
			GameObjectList = new ArrayList<GameObject>();
		}

		setScreenOffset();

		while(!Display.isCloseRequested()) {
			fpsCounter.updateFPS();

			GameObjectList = state.getCurrentScene().getSceneObjects();
			if (Game.screenOffset == null)
				setScreenOffset();

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
			
			for(GameObject GameObj : GameObjectList) {
				GameObj.update();

				//Set the color to white by default
				GL11.glColor3f(255, 255, 255);
				GL11.glShadeModel(GL11.GL_SMOOTH);
				GL11.glLoadIdentity();
				GL11.glPushMatrix();
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

				switch(GameObj.getType()){
					case PLAYER:
						//Set the cameraOffset to the characters position.
						cameraOffset = new Vector2f(GameObj.getPosition().x - screenOffset.x, GameObj.getPosition().y - screenOffset.y);

						//Draw the character in the center of the screen.
						GL11.glTranslatef(GameObj.getPosition().x - cameraOffset.x, GameObj.getPosition().y - cameraOffset.y, 0);
						break;
					case COLLISON:
						GL11.glTranslatef(GameObj.getScreenPosition(cameraOffset).x, GameObj.getScreenPosition(cameraOffset).y, 0);
						break;
					case TEXT:
						break;
					case NON_COLLISON:
						GL11.glTranslatef(GameObj.getScreenPosition(cameraOffset).x, GameObj.getScreenPosition(cameraOffset).y, 0);
						break;
					default:
						GL11.glTranslatef(GameObj.getScreenPosition(cameraOffset).x, GameObj.getScreenPosition(cameraOffset).y, 0);
						break;
				}

				GameObj.getTexture().bind();
				GameObj.draw();

				GL11.glPopMatrix();
			}

			Display.update();
			Display.sync(60);
		}

		Display.destroy();
	}

	private void setScreenOffset(){
		for(GameObject GameObj : GameObjectList) {
			if(GameObj.getType().equals(GameObjectType.PLAYER)){
				screenOffset = new Vector2f(Game.getScreenWidth()/2, Game.getScreenHeight()/2);
			}
		}
	}

	/**
	 * @return the current scene
	 */
	public static Scene getCurrentScene(){
		return Game.getContext().state.getCurrentScene();
	}

	/**
	 * @return
	 */
	public static Game getContext() {
		if(Game.context == null){
			Game.context = new Game();
			return Game.context;
		}
		else{
			return Game.context;
		}
	}
	
	public static void setDisplayMode(DisplayMode dspMode) {
		displayMode = dspMode;
	}
	
	public static DisplayMode getDisplayMode() {
		return displayMode;
	}

	public static int getScreenWidth() {
		return displayMode.getWidth();
	}

	public static int getScreenHeight() {
		return displayMode.getHeight();
	}
}
