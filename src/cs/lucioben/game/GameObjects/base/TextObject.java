package cs.lucioben.game.GameObjects.base;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import cs.lucioben.game.base.GameObject;

public class TextObject extends GameObject {
	private TrueTypeFont font;
	private String str;
	private Color color;
	public TextObject(String str, int x, int y) {
		this(str, x, y, Color.white);
	}
	
	public TextObject(String str, int x, int y, Color color) {
		super(0, 0, x, y);
		try {
			this.str = str;
			this.color = color;
			this.font = new TrueTypeFont(Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("/res/fonts/Plump.ttf")).deriveFont(24f), false);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		return;
	}

	@Override
	public void draw() {
		Color.white.bind();
		this.font.drawString(this.x, this.y, this.str, this.color);
	}

}
