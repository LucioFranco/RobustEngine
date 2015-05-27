package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.Player;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.Scene;

public class SecondScene extends Scene {
	private final Vector2f startingPosition; 

	public SecondScene() {
		startingPosition = new Vector2f(100, 200);
	}

	@Override
	public void setup() {
		class EmptyTest extends GameObject {

			@Override
			public void update() {
				System.out.println("Hello");
				
			}

			@Override
			public void draw() {
				// TODO Auto-generated method stub
				
			}
			
		}
		this.add(new Player(50, 40, 0, startingPosition));
		this.add(new EmptyTest());
	}

}
