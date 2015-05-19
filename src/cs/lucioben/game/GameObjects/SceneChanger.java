package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;

import cs.lucioben.game.GameObjects.base.EmptyObject;
import cs.lucioben.game.base.Game;

public class SceneChanger extends EmptyObject {

	public SceneChanger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			Game.getContext().state.next();
		}
	}
}
