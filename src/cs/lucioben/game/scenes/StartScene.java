package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Enemy;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.MapTile;
import cs.lucioben.game.GameObjects.base.MutliLayerObject;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.GameObjectType;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {

	@Override
	public void setup() {
		MapTile wall = new MapTile(96, 96, "res/images/wall.png", GameObjectType.COLLISON), floor =  new MapTile(96, 96, "res/images/floor.png", GameObjectType.NON_COLLISON);
		this.setMapFileName("res/maps/StartScene.txt");
		this.addMapTile("-", wall);
		this.addMapTile("`", floor);

		Player player = new Player(96, 96, 64, 64, 0, new Vector2f(200, 100), "res/images/player.png");
		player.setType(GameObjectType.PLAYER);
		this.add(player);
		
		this.addMapTile("E", new MutliLayerObject(96, 96, new Enemy(new Vector2f(0, 0), player), floor));

		TextObject text = new TextObject("Level 1", new Vector2f(10, 10));
		this.add(text);
	}
}
