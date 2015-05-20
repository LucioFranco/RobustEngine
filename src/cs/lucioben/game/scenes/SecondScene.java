package cs.lucioben.game.scenes;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import cs.lucioben.game.GameObjects.Square;
import cs.lucioben.game.GameObjects.base.TextObject;
import cs.lucioben.game.base.GameObject;
import cs.lucioben.game.base.Scene;

public class SecondScene extends Scene {

	public SecondScene() {
		// TODO Auto-generated constructor stub
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
		this.add(new Square(50, 40, 0, new Vector2f(100, 200)));
		this.add(new Square(-50, 50, 0, new Vector2f(100, 200)));
		this.add(new Square(-70, 50, 0, new Vector2f(100, 200)));
		this.add(new Square(20, 30, 0, new Vector2f(100, 200)));
		this.add(new Square(80, 20, 0, new Vector2f(100, 200)));
		this.add(new EmptyTest());
		this.add(new TextObject("HEllo WORLD", 0, 0, Color.green));

	}

}
