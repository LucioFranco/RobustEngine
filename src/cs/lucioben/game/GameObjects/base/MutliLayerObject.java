package cs.lucioben.game.GameObjects.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.base.GameObject;

public class MutliLayerObject extends GameObject {
	private GameObject obj;
	private MapTile tile;
	
	public MutliLayerObject(int width, int height, GameObject obj, MapTile tile) {
		super(96, 96, 0, new Vector2f(0, 0));
		this.obj = obj;
		this.tile = tile;
	}

	@Override
	public void update() {
		obj.update();
		tile.update();
	}

	@Override
	public void draw() {
		tile.setPosition(this.getPosition());
		GL11.glRotatef(tile.getRotation(), 0, 0, 1);
		tile.getTexture().bind();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0); 
		GL11.glVertex2f(-this.getWidth()/2, -this.getHeight()/2);
		
		GL11.glTexCoord2f(0,1); 
		GL11.glVertex2f(-this.getWidth()/2, this.getHeight()/2);

		GL11.glTexCoord2f(1,1); 
		GL11.glVertex2f(this.getWidth()/2, this.getHeight()/2);
		
		GL11.glTexCoord2f(1,0); 
		GL11.glVertex2f(this.getWidth()/2, -this.getHeight()/2);
		GL11.glEnd();
		
		obj.setPosition(this.getPosition());
		GL11.glRotatef(obj.getRotation(), 0, 0, 1);
		obj.getTexture().bind();
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0); 
		GL11.glVertex2f(-this.getWidth()/2, -this.getHeight()/2);
		
		GL11.glTexCoord2f(0,1); 
		GL11.glVertex2f(-this.getWidth()/2, this.getHeight()/2);

		GL11.glTexCoord2f(1,1); 
		GL11.glVertex2f(this.getWidth()/2, this.getHeight()/2);
		
		GL11.glTexCoord2f(1,0); 
		GL11.glVertex2f(this.getWidth()/2, -this.getHeight()/2);
		GL11.glEnd();
	}

}
