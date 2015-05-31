package cs.lucioben.game.GameObjects.base;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import cs.lucioben.game.base.GameObject;

public class TextObject extends GameObject {
	private TrueTypeFont font;
	private String str;
	private Color color;
	private float size;
	
	public TextObject(String str, Vector2f pos) {
		this(str, pos, Color.white, 24f);
	}
	
	public TextObject(String str, Vector2f pos, Color color) {
		this(str, pos, color, 24f);
	}
	
	public TextObject(String str, Vector2f pos, Color color, float size) {
		super(0, 0, 0, pos);
		super.setType(2);
		try {
			this.str = str;
			this.color = color;
			this.size = size;
			this.font = new TrueTypeFont(Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("/res/fonts/Plump.ttf")).deriveFont(size), true);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public TrueTypeFont getFont() {
		return this.font;
	}
	

	@Override
	public void update() {
		return;
	}

	@Override
	public void draw() {	
		GL11.glEnable(GL11.GL_BLEND);
	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		this.font.drawString(this.getPosition().x, this.getPosition().y, this.str, this.color);
		
		GL11.glDisable(GL11.GL_BLEND);
	}

	public float getSize() {
		return this.size;
	}
}
