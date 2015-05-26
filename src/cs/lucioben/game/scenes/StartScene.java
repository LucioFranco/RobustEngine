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
		this.add(new Square(128, 64, 0, new Vector2f(100, 200), "res/images/AND.png"));
		this.add(new Square(128, 64, 0, new Vector2f(100, 500), "res/images/OR.png"));
		this.add(new SceneChanger());
		this.add(new TextObject("HELLO WORLD", 10, 10, Color.green));
	}
}
