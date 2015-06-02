package cs.lucioben.game.scenes;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.base.EmptyObject;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.Scene;

public class GameOverScene extends Scene {

	@Override
	public void setup() {
		class RetryChanger extends EmptyObject {
			@Override
			public void update() {
				if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
					Game.getContext().state.back();
				}
				
			}
		}
		this.add(new TextObject("You Died", new Vector2f(Game.getScreenWidth() / 2 - 150, Game.getScreenHeight() / 2), Color.white, 45f));
		this.add(new TextObject("Press Space to Retry", new Vector2f(Game.getScreenWidth() / 2 - 185, Game.getScreenHeight() / 2 + 50), Color.white, 26f));
		this.add(new RetryChanger());
	}
}
