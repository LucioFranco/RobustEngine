/** 
 * The abstract class for a scene
 * 
 * @author Lucio Franco
 * @version 1.0 
 * @since June 2, 2015
 */

package cs.lucioben.game.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.lwjgl.util.vector.Vector2f;

public abstract class Scene {
	private ArrayList<GameObject> SceneObjects;
	private HashMap<String, GameObject> MapKeywords;
	private String MapFile;
	
	/**
	 * The constructor for a scene. 
	 */
	public Scene() {
		 this(null);
	}
	
	/**
	 * Loads a map file into a scene. 
	 * @param MapFile the file to load in. 
	 */
	public Scene(String MapFile) {
		this.MapFile = MapFile;
		this.SceneObjects = new ArrayList<GameObject>();
		this.MapKeywords = new HashMap<String, GameObject>();
	}
	
	/**
	 * An abstract setup method.
	 */
	public abstract void setup();
	
	/**
	 * Goes to the next scene. 
	 */
	public static Scene nextScene() {
		return null;
	}

	/**
	 * Adds a game object to the scene. 
	 * @param obj The object to add
	 */
	public void add(GameObject obj) {
		ArrayList<GameObject> newList = new ArrayList<>();
		
		for(GameObject g : SceneObjects){
			newList.add(g);
		}
		
		newList.add(obj);
		SceneObjects = newList;
	}
	
	/**
	 * Adds a map tile to the scene. 
	 * @param key the map key
	 * @param obj the object to add associated with the key. 
	 */
	public void addMapTile(String key, GameObject obj) {
		this.MapKeywords.put(key, obj);
	}
	
	/**
	 * Sets the map file name
	 * @param str the map file name 
	 */
	public void setMapFileName(String str) {
		this.MapFile = str;
	}
	
	/**
	 * Remove a game object from the scene. 
	 * @param obj the object to remove. 
	 */
	public void remove(GameObject obj){
		ArrayList<GameObject> newList = new ArrayList<>();
		
		for(GameObject g : SceneObjects){
			newList.add(g);
		}
		
		newList.remove(obj);
		SceneObjects = newList;
	}

	/**
	 * Gets a list of the scene objects. 
	 * @return an arraylist of gameobjects in the scene. 
	 */
	public ArrayList<GameObject> getSceneObjects() {
		return SceneObjects;
	}
	
	/**
	 * Cleans the scene. 
	 */
	public void clean() {
		this.SceneObjects = new ArrayList<GameObject>();
		this.MapKeywords = new HashMap<String, GameObject>();
	}
	
	/**
	 * Converts the scene into a string. 
	 */
	public String toString() {
		String temp = this.getClass().getName() + "\n";
		for(GameObject obj : this.SceneObjects) {
			temp += "	" + obj.getClass().getName() + "\n";
		}
		return temp;
	}
	
	/**
	 * Loads assets into the map.
	 */
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
						GameObject tile = this.MapKeywords.get("" + v[i]);
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