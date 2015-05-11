package cs.lucioben.game.base;

import java.util.Iterator;

import org.lwjgl.opengl.Display;

@SuppressWarnings("rawtypes")
public class State implements Iterator {
	private Scene[] sceneList;
	private int index;
	private Scene currentScene;
	public State(Scene[] sceneList) {
		this.sceneList = sceneList;
		this.index = 0;
		this.currentScene = sceneList[0];
		for(Scene s : sceneList) {
			s.setup();
		}
	}
	
	public Scene getCurrentScene() {
		return this.currentScene;
	}
	
	@Override
	public boolean hasNext() {
		if(this.sceneList == null || this.index == this.sceneList.length) {
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
			index++;
			this.currentScene = sceneList[index - 1];
			System.out.println(sceneList[index - 1].getClass().getName());
			return sceneList[index - 1];
		}
	}
	@Override
	public void remove() {
		// TODO find better fix for this
		System.err.println("State remove does nothing sorry :(");
	}
}
