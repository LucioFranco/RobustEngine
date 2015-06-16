/** 
 * A game object designed to display text.
 * 
 * @author Lucio Franco and Benjamin Snoha
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.GameObjects.base;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class TextObject extends GameObject {
	private TrueTypeFont font;
	private String str;
	private Color color;
	private float size;
	
	/**
	 * A constructor for the text object
	 * @param str the string of text
	 * @param pos the position of the text
	 */
	public TextObject(String str, Vector2f pos) {
		this(str, pos, Color.white, 24f);
	}
	
	/**
	 * A constructor for the text object
	 * @param str the string of text
	 * @param pos the position of the text
	 * @param color the color of the text
	 */
	public TextObject(String str, Vector2f pos, Color color) {
		this(str, pos, color, 24f);
	}
	
	/**
	 * A constructor for the text object
	 * @param str the string of text
	 * @param pos the position of the text
	 * @param color the color of the text
	 * @param size the size of the text
	 */
	public TextObject(String str, Vector2f pos, Color color, float size) {
		super(0, 0, 0, pos);
		super.setType(GameObjectType.TEXT);
		try {
			this.str = str;
			this.color = color;
			this.size = size;
			this.font = new TrueTypeFont(Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(Game.getFontPath())).deriveFont(size), true);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the font of the string.
	 * @return the font of the string. 
	 */
	public TrueTypeFont getFont() {
		return this.font;
	}
	
	/**
	 * Updates the text (currently does nothing
	 */
	@Override
	public void update() {
		return;
	}

	/**
	 * Draws the text
	 */
	@Override
	public void draw() {	
		GL11.glEnable(GL11.GL_BLEND);
	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	    
		this.font.drawString(0, 0, this.str, this.color);
		
		GL11.glDisable(GL11.GL_BLEND);
	}

	/**
	 * Gets the size of the text
	 * @return the size of the text
	 */
	public float getSize() {
		return this.size;
	}
}
