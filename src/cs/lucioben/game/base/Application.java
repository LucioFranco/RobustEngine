package cs.lucioben.game.base;

import cs.lucioben.game.scenes.SecondScene;
import cs.lucioben.game.scenes.StartScene;
import cs.lucioben.game.scenes.TitleScene;

public class Application {
	public static void main(String[] args) {
		Scene[] scenes = {new TitleScene(), new StartScene(), new SecondScene()};
		Game game = Game.getContext();
		game.start(scenes);
	}
}