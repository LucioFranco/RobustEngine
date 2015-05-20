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
			this.position.y -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.position.x -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.position.y += 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.position.x += 10;
		}
	}

	@Override
	public void draw() {
		GL11.glColor3f(0.3f, 0.8f, 0.3f);
		GL11.glVertex2f(this.position.x, this.position.y);
		GL11.glVertex2f(this.position.x, this.position.y + this.height);
		GL11.glVertex2f(this.position.x + this.width, this.position.y + this.height);
		GL11.glVertex2f(this.position.x + this.width, this.position.y);
	}

}
