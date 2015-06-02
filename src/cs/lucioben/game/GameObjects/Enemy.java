package cs.lucioben.game.GameObjects;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.base.MapTile;
import cs.lucioben.game.base.Game;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.GameObjectType;

public class Enemy extends GameObject{
	private static final int WIDTH = 96;
	private static final int HEIGHT = 96;
	private final float SPEED = 2; 
	private float health = 100;
	private Player player; 
	private long shootDelay = 1000;
	private long lastTime = System.currentTimeMillis();
	private Vector2f velocity = new Vector2f(0,0);
	private MapTile bg;
	private float playerBuffer = 500;
	
	public Enemy(Vector2f startingPosition, Player player, MapTile bg){
		super(WIDTH, HEIGHT, 0, startingPosition);
		this.setTexture("res/images/turret.png");
		this.setType(GameObjectType.ENEMY);
		this.player = player;
		this.bg = bg;
		this.setBoundingBoxWidth(64);
		this.setBoundingBoxWidth(64);
	}
	
	@Override
	public void update() {
		if(health <= 0){
			this.setTexture("res/images/turretDead.png");
		}
		else{
			float tx = player.getPosition().x - this.getPosition().x;
			float ty = player.getPosition().y - this.getPosition().y;
			float dist = (float)Math.sqrt(tx * tx + ty * ty);
			velocity.x = (tx/dist) * SPEED;
			velocity.y = (ty/dist) * SPEED;
			
			if(dist < playerBuffer){
				this.setRotation((float)(Math.atan2(player.getPosition().y - this.getPosition().y, player.getPosition().x - this.getPosition().x) * (180/Math.PI)));
			
				if(System.currentTimeMillis() - lastTime > shootDelay){
					shoot();
					lastTime = System.currentTimeMillis();
				}
			}
		}
	}
	
	public void takeDamage(float amount){
		health -= amount;
	}
	
	public void shoot(){
		Bullet bullet = new Bullet(this.getPosition(), this.getRotation());
		bullet.setEnemyBullet(true);
		Game.getCurrentScene().add(bullet);
	}
	
	@Override
	public void draw() {
		bg.getTexture().bind();
		GL11.glRotatef(bg.getRotation(), 0, 0, 1);
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
		
		
		GL11.glRotatef(this.getRotation(), 0, 0, 1);
		this.getTexture().bind();
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
