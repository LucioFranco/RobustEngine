package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	@Override
	public void setup() {
		Player player = new Player(128, 64, 0, new Vector2f(200,0));
		player.setType(0);

		TextObject text = new TextObject("HELLO WORLD", new Vector2f(10, 10));
		
		this.loadAssets("res/assets0.txt", this);
		this.add(player);
		this.add(text);
	}
}
