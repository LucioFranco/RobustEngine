package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.Square;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	public StartScene() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup() {
		Square square = new Square(50, 50, 0, new Vector2f(100, 200));
		square.setRotation(45);
		this.add(square);
		this.add(new SceneChanger());
	}
}
