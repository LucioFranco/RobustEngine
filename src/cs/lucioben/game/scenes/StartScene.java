package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.MapTile;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.GameObjectType;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	@Override
	public void setup() {
		this.setMapFileName("res/maps/StartScene.txt");
		this.addMapTile("-", new MapTile(96, 96, "res/images/wall.png"));
		this.addMapTile("`", new MapTile(96, 96, "res/images/floor.png"));
		
		Player player = new Player(64, 64, 0, new Vector2f(200, 100), "res/images/player.png");
		player.setType(GameObjectType.PLAYER);

		TextObject text = new TextObject("Level 1", new Vector2f(10, 10));
		this.add(player);
		this.add(text);
	}
}
