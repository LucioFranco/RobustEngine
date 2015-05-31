package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import cs.lucioben.game.GameObjects.SceneChanger;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.Scene;

public class TitleScene extends Scene {
	@Override
	public void setup() {
		this.add(new TextObject("KILL the GAME", new Vector2f(Game.getScreenWidth() / 2 - 150, Game.getScreenHeight() / 2), Color.white, 45f));
		this.add(new TextObject("Press Space to Continue", new Vector2f(Game.getScreenWidth() / 2 - 185, Game.getScreenHeight() / 2 + 50), Color.white, 26f));
		this.add(new SceneChanger());
	}
}
