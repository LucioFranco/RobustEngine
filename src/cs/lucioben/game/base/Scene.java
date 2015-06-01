package cs.lucioben.game.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.lwjgl.util.vector.Vector2f;

import cs.lucioben.game.GameObjects.base.MapTile;

public abstract class Scene {
	private ArrayList<GameObject> SceneObjects;
	private HashMap<String, MapTile> MapKeywords;
	private String MapFile;
	public Scene() {
		 this(null);
	}
	
	public Scene(String MapFile) {
		this.MapFile = MapFile;
		this.SceneObjects = new ArrayList<GameObject>();
		this.MapKeywords = new HashMap<String, MapTile>();
	}
	
	public abstract void setup();
	
	public static Scene nextScene() {
		return null;
	}

	public void add(GameObject obj) {
		ArrayList<GameObject> newList = new ArrayList<>();
		
		for(GameObject g : SceneObjects){
			newList.add(g);
		}
		
		newList.add(obj);
		SceneObjects = newList;
	}
	
	public void addMapTile(String key, MapTile obj) {
		this.MapKeywords.put(key, obj);
	}
	
	public void setMapFileName(String str) {
		this.MapFile = str;
	}
	
	public void remove(GameObject obj){
		this.SceneObjects.remove(obj);
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
	
	public void loadAssets(){
		//Loads in assets in a very specific format based on input file.
		//In the file, '-'s are walls. 
		if(this.MapFile != null) {
			try {
				FileInputStream file = new FileInputStream(MapFile);
				Scanner input = new Scanner(file);
				String line = null;
			
				int lineCount = 0;
				while(input.hasNextLine()){
					line = input.nextLine();
					char[] v = line.toCharArray();
					
					for(int i = 0; i < v.length; i++){
						MapTile tile = this.MapKeywords.get("" + v[i]);
						System.out.println(this.MapKeywords.get("" + v[i]));
						if(tile != null) {
							tile.setPosition(new Vector2f(tile.getWidth() * i, tile.getHeight() * lineCount));
							this.SceneObjects.add(0, tile.clone());	
						}
					}
					
					lineCount++;
				}
				
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
}