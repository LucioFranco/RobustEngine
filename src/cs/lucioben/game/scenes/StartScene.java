package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.Square;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {
	private final Vector2f startingPosition; 
	
	public StartScene() {
		startingPosition = new Vector2f(100, 200);
	}

	@Override
	public void setup() {
		this.add(new Square(128, 64, 0, startingPosition));
		this.add(new SceneChanger());
		this.add(new TextObject("HELLO WORLD", 10, 10, Color.green));
	}
}
