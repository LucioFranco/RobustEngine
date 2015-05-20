package cs.lucioben.game.GameObjects.base;

import cs.lucioben.game.base.GameObject;

public abstract class EmptyObject extends GameObject {

	public EmptyObject() {
		super(0,0,0,0);
	}

	public abstract void update();

	@Override
	public void draw() {
		return;
	}

}