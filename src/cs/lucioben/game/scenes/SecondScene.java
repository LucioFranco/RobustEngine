package cs.lucioben.game.scenes;

import cs.lucioben.game.GameObjects.Square;
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
		this.add(new Square(50, 40, 100, 200));
		this.add(new Square(-50, 50, 100, 200));
		this.add(new Square(-70, 50, 100, 200));
		this.add(new Square(20, 30, 100, 200));
		this.add(new Square(80, 20, 100, 200));
		this.add(new EmptyTest());

	}

}
