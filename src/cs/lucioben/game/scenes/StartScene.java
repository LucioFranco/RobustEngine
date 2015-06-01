package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Enemy;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.GameObjectType;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	@Override
	public void setup() {
		this.loadAssets("res/assets0.txt", this);

		Player player = new Player(64, 64, 0, new Vector2f(200, 100), "res/images/player.png");
		player.setType(GameObjectType.PLAYER);
		this.add(player);

		
		Enemy enemy = new Enemy(new Vector2f(200, 400), player);
		enemy.setType(GameObjectType.COLLISON);
		this.add(enemy);

		TextObject text = new TextObject("Level 1", new Vector2f(10, 10));
		this.add(text);
	}
}
