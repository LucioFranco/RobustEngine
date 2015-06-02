package cs.lucioben.game.base;

import java.util.Iterator;

import org.lwjgl.opengl.Display;

@SuppressWarnings("rawtypes")
public class State implements Iterator {
	private Scene[] sceneList;
	private int index;
	private Scene currentScene;
	private boolean tempScene;
	public State(Scene[] sceneList) {
		this.sceneList = sceneList;
		this.index = -1;
		this.currentScene = sceneList[0];
		this.tempScene = false;
	}
	
	public Scene getCurrentScene() {
		return this.currentScene;
	}
	
	public void transitionTo(Scene scene) {
		this.tempScene = true;
		this.currentScene = scene;
		this.loadScene(this.currentScene);
	}
	
	public void transitionTo(int i) {
		this.tempScene = false;
		this.currentScene = this.sceneList[i];
		this.loadScene(this.currentScene);
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public Scene back() {
		if(!tempScene) {
			index--;
		}
		this.currentScene = this.sceneList[index];
		this.loadScene(this.currentScene);
		return this.currentScene;
	}
	
	@Override
	public boolean hasNext() {
		if(this.sceneList == null || this.index == this.sceneList.length - 1) {
			return false;
		}else {
			return true;
		}
	}
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
	@Override
	public void remove() {
		// TODO find better fix for this
		System.err.println("State remove does nothing sorry :(");
	}
	
	private void loadScene(Scene scene) {
		scene.clean();
		scene.setup();
		scene.loadAssets();
	}
}
