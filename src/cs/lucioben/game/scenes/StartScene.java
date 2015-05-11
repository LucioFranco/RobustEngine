package cs.lucioben.game.scenes;

import java.util.ArrayList;

import cs.lucioben.game.GameObjects.EmptyObject;
import cs.lucioben.game.GameObjects.Square;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	public StartScene() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup() {
		this.add(new Square(50, 50, 100, 200));
		this.add(new EmptyObject());
	}
}
