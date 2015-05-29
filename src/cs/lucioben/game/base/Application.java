package cs.lucioben.game.base;

import cs.lucioben.game.scenes.SecondScene;
import cs.lucioben.game.scenes.StartScene;

public class Application {
	public static void main(String[] args) {
		Scene[] scenes = {new StartScene(), new SecondScene()};
		Game game = Game.getContext();
		game.start(scenes);
	}
}