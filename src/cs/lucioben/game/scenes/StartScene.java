package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.GameObjects.Wall;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.Scene;

public class StartScene extends Scene {	
	public StartScene() {
	}

	@Override
	public void setup() {
		Player player = new Player(128, 64, 0, new Vector2f(0,0));
	
		Vector2f startingPosition = new Vector2f(0,0);
		player.setPosition(startingPosition);
		player.setType(0);
		
		this.add(player);
		
		Wall wall = new Wall(128, 64, 0, new Vector2f(100, 100), "res/images/AND.png");
		wall.setType(1);
		
		this.add(wall);
		this.add(new SceneChanger());
		
		TextObject text = new TextObject("HELLO WORLD", 10, 10);
		text.setType(2);
		
		this.add(text);
	}
}
