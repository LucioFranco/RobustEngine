/** 
 * The state class for state management
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.base;

import java.util.Iterator;

import org.lwjgl.opengl.Display;

@SuppressWarnings("rawtypes")
public class State implements Iterator {
	private Scene[] sceneList;
	private int index;
	private Scene currentScene;
	private boolean tempScene;
	
	/**
	 * The constructor for a scene. 
	 * @param sceneList the list of scenes in the game. 
	 */
	public State(Scene[] sceneList) {
		this.sceneList = sceneList;
		this.index = -1;
		this.currentScene = sceneList[0];
		this.tempScene = false;
	}
	
	/**
	 * Gets the current scene. 
	 * @return the current scene. 
	 */
	public Scene getCurrentScene() {
		return this.currentScene;
	}
	
	/**
	 * Transition to another scene.
	 * @param scene The scene to transition to. 
	 */
	public void transitionTo(Scene scene) {
		this.tempScene = true;
		this.currentScene = scene;
		this.loadScene(this.currentScene);
	}
	
	/**
	 * Transition to another scene.
	 * @param scene The index of the scene to transition to. 
	 */
	public void transitionTo(int i) {
		this.tempScene = false;
		this.currentScene = this.sceneList[i];
		this.loadScene(this.currentScene);
	}
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return this.index;
	}
	
	/**
	 * Goes back to the previous scene.
	 * @return the scene to return to. 
	 */
	public Scene back() {
		if(!tempScene) {
			index--;
		}
		this.currentScene = this.sceneList[index];
		this.loadScene(this.currentScene);
		return this.currentScene;
	}
	
	/**
	 * Transition to another scene.
	 * @return if there is another scene. 
	 */
	@Override
	public boolean hasNext() {
		if(this.sceneList == null || this.index == this.sceneList.length - 1) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Transition to the next scene.
	 * @return the next scene. 
	 */
	@Override
	public Scene next() {
		if(!hasNext()) {
			Display.destroy();
			return null;
		}else {
			this.tempScene = false;
			index++;
			this.currentScene = sceneList[index];
			System.out.println(sceneList[index].getClass().getName());
			this.loadScene(this.currentScene);
			return this.currentScene;
		}
	}
	
	private void loadScene(Scene scene) {
		scene.clean();
		scene.setup();
		scene.loadAssets();
	}

	@Override
	public void remove() {
		try {
			throw new Exception("Method does not exsist");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
