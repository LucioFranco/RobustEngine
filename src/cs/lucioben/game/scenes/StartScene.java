package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.Square;
import cs.lucioben.game.GameObjects.base.TextObject;
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
		this.add(new TextObject("HELLO WORLD", 10, 10, Color.green));
	}
}
