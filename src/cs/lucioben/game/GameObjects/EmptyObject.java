package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;

public class EmptyObject extends GameObject {

	public EmptyObject() {
		super(0,0,0,0);
	}

	public EmptyObject(int width, int height, int x, int y) {
		super(width, height, x, y);
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			Game.getContext().state.next();
		}

	}

	@Override
	public void draw() {
		return;
	}

}
