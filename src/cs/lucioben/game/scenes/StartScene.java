package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

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
	
		//Set the initial position of the player to the center of the screen.
		Vector2f startingPosition = new Vector2f(Game.getScreenWidth()/2 - player.getWidth()/2, Game.getScreenHeight()/2 - player.getHeight()/2);
		player.setPosition(startingPosition);
		player.setType(0);
		
		this.add(player);
		
		Wall wall = new Wall(128, 64, 0, new Vector2f(0, 0), "res/images/AND.png");
		wall.setType(1);
		
		this.add(wall);
		this.add(new SceneChanger());
		
		TextObject text = new TextObject("HELLO WORLD", 10, 10, Color.green);
		text.setType(2);
		
		this.add(text);
	}
}
