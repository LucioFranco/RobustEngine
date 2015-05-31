package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	@Override
	public void setup() {
		Player player = new Player(64, 64, 0, new Vector2f(200, 100), "res/images/player.png");
		player.setType(0);

		TextObject text = new TextObject("Level 1", new Vector2f(10, 10));

		this.loadAssets("res/assets0.txt", this);
		this.add(player);
		this.add(text);
	}
}
