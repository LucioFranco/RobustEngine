package cs.lucioben.game.GameObjects;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cs.lucioben.game.base.GameObject;

public class Square extends GameObject {

	public Square(int i, int j, int k, int l) {
		super(i, j, k, l);
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.y -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.x -= 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.y += 10;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.x += 10;
		}
	}

	@Override
	public void draw() {
		GL11.glColor3f(0.3f, 0.8f, 0.3f);
		GL11.glVertex2i(this.x, this.y);
		GL11.glVertex2i(this.x, this.y + this.height);
		GL11.glVertex2i(this.x + this.width, this.y + this.height);
		GL11.glVertex2i(this.x + this.width, this.y);
	}

}
