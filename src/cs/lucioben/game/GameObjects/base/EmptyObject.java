package cs.lucioben.game.GameObjects.base;

import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.base.GameObject;

public abstract class EmptyObject extends GameObject {

	public EmptyObject() {
		super(0, 0, 0, new Vector2f(0,0));
	}

	public abstract void update();

	@Override
	public void draw() {
		return;
	}

}
