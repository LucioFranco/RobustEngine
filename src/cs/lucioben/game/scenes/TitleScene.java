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
		this.add(new TextObject("SOME GAME", new Vector2f(Game.getScreenWidth() / 2, Game.getScreenHeight() / 2), Color.white, 45f));
		this.add(new SceneChanger());
	}
}
