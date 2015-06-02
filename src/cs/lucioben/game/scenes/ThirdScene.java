package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Enemy;
import cs.lucioben.game.GameObjects.Health;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.base.MapTile;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObjectType;
import cs.lucioben.game.base.Scene;

public class ThirdScene extends Scene {

	@Override
	public void setup() {
		MapTile wall = new MapTile(96, 96, "res/images/wall.png", GameObjectType.COLLISON), 
				floor =  new MapTile(96, 96, "res/images/floor.png", GameObjectType.NON_COLLISON), 
				end = new MapTile(96, 96, "res/images/end.png", GameObjectType.END);
		this.setMapFileName("res/maps/ThirdScene.txt");
		this.addMapTile("-", wall);
		this.addMapTile("`", floor);
		this.addMapTile("F", end);

		Player player = new Player(96, 96, 0, new Vector2f(200, 100), "res/images/player.png");
		player.setType(GameObjectType.PLAYER);
		this.add(player);
		
		this.addMapTile("E", new Enemy(new Vector2f(0, 0), player, floor));

		TextObject text = new TextObject("Level 3", new Vector2f(10, 10));
		this.add(text);
		
		Health health = new Health(Game.getScreenWidth(), 50, new Vector2f(0, Game.getScreenHeight() - 25),"res/images/health.png", player);
		this.add(health);
	}
}