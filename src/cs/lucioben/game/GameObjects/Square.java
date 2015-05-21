package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class Square extends GameObject {

	public Square(int i, int j, float rotation, Vector2f position) {
		super(i, j, rotation, position);
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.getPosition().y -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.getPosition().x -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.getPosition().y += 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.getPosition().x += 10;
		}
	}

	@Override
	public void draw() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(0.3f, 0.8f, 0.3f);
		GL11.glVertex2f(this.getPosition().x, this.getPosition().y);
		GL11.glVertex2f(this.getPosition().x, this.getPosition().y + this.getHeight());
		GL11.glVertex2f(this.getPosition().x + this.getWidth(), this.getPosition().y + this.getHeight());
		GL11.glVertex2f(this.getPosition().x + this.getWidth(), this.getPosition().y);
		GL11.glEnd();
	}

}
