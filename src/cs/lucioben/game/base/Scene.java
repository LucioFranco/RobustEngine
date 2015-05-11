package cs.lucioben.game.base;

import java.util.ArrayList;

public abstract class Scene {
	private ArrayList<GameObject> SceneObjects;
	public Scene() {
		 this.SceneObjects = new ArrayList<GameObject>();
	}
	
	public abstract void setup();
	
	public static Scene nextScene() {
		return null;
	}

	public void add(GameObject obj) {
		this.SceneObjects.add(obj);
	}

	public ArrayList<GameObject> getSceneObjects() {
		return SceneObjects;
	}
	
	public String toString() {
		String temp = this.getClass().getName() + "\n";
		for(GameObject obj : this.SceneObjects) {
			temp += "	" + obj.getClass().getName() + "\n";
		}
		return temp;
	}
}
