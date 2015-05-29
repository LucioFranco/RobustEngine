package cs.lucioben.game.base;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.Wall;

public class Game {

	private static int screenWidth = 800;
	private static int screenHeight = 600;
	private static String title = "openGl Game";
	private static Game context;
	private static FPSCounter fpsCounter = FPSCounter.getInstance();
	private static ArrayList<GameObject> GameObjectList;
	private static Vector2f cameraOffset;
	private static Vector2f screenOffset;

	public State state;

	private Game(int width, int height) {
		cameraOffset = new Vector2f(Game.getScreenWidth()/2, Game.getScreenHeight()/2);

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
		GL11.glOrtho(0, getScreenWidth(), getScreenHeight(), 0, 0, -1);
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

		setScreenOffset();

		while(!Display.isCloseRequested()){
			fpsCounter.updateFPS();

			GameObjectList = state.getCurrentScene().getSceneObjects();
			if (this.screenOffset == null)
				setScreenOffset();

			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

			for(GameObject GameObj : GameObjectList) {
				GameObj.update();

				//Set the color to white by default
				GL11.glColor3f(255, 255, 255);
				GL11.glLoadIdentity();
				GL11.glPushMatrix();

				switch(GameObj.getType()){
					case 0:{
						//Set the cameraOffset to the characters position.
						cameraOffset = new Vector2f(GameObj.getPosition().x - screenOffset.x, GameObj.getPosition().y - screenOffset.y);

						//Draw the character in the center of the screen.
						GL11.glTranslatef(GameObj.getPosition().x - cameraOffset.x, GameObj.getPosition().y - cameraOffset.y, 0);

						//Pass the current object list to the player, so they can check for collision.
						((Player)GameObj).detectCollision(GameObjectList);

					}
					break;
					case 1:{
						GL11.glTranslatef(((Wall)GameObj).getScreenPosition(cameraOffset).x, ((Wall)GameObj).getScreenPosition(cameraOffset).y, 0);
					}
					break;
					default:{}
				}

				GL11.glRotatef(GameObj.getRotation(), 0, 0, 1);

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
			if(GameObj.getType() == 0){
				screenOffset = new Vector2f(Game.getScreenWidth()/2 - GameObj.getWidth()/2, Game.getScreenHeight()/2 - GameObj.getHeight()/2);
			}
		}
	}

	public static Game getContext() {
		if(Game.context == null){
			Game.context = new Game(Game.getScreenWidth(), Game.getScreenHeight());
			return Game.context;
		}
		else{
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
