package cs.lucioben.game.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.lwjgl.util.vector.Vector2f;
import cs.lucioben.game.GameObjects.Wall;

public abstract class Scene {
	private ArrayList<GameObject> SceneObjects;
	public Scene() {
		 this.SceneObjects = new ArrayList<GameObject>();
	}
	
	public abstract void setup();
	
	public static Scene nextScene() {
		return null;
	}

	public void add(GameObject obj) {
		this.SceneObjects.add(obj);
	}

	public ArrayList<GameObject> getSceneObjects() {
		return SceneObjects;
	}
	
	public String toString() {
		String temp = this.getClass().getName() + "\n";
		for(GameObject obj : this.SceneObjects) {
			temp += "	" + obj.getClass().getName() + "\n";
		}
		return temp;
	}
	
	public void loadAssets(String fileName, Scene scene){
		//Loads in assets in a very specific format based on input file.
		//In the file, '-'s are walls. 
		
		try {
		
			FileInputStream file = new FileInputStream(fileName);
			Scanner input = new Scanner(file);
			String line = null;
		
			int lineCount = 0;
			while(input.hasNextLine()){
				line = input.nextLine();
				char[] v = line.toCharArray();
				
				for(int i = 0; i < v.length; i++){
					if(v[i] == '-'){
						Wall wall = new Wall(new Vector2f(Wall.getTileWidth() * i, Wall.getTileHeight() * lineCount));
						wall.setType(1);
						scene.add(wall);
					}
				}
				
				lineCount++;
			}
			
			input.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}