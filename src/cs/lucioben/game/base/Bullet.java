package cs.lucioben.game.base;

public class Bullet{
	/*
	private static int bulletCounter = 0;
	private int localIndex = 0;
	private GameObject bullet;
	private Vector3 velocity; 
	private float rotation;
	private readonly int DAMAGE = 100;
	private readonly float SPEED = 15f; 
	
	public Bullet(Vector2 startingPosition, float a, GameObject bulletObject){
		bullet = GameObject.Instantiate(bulletObject);
		bullet.transform.position = startingPosition;
		bullet.transform.rotation = Quaternion.AngleAxis(a, Vector3.forward);
		
		SpriteRenderer renderer = bullet.GetComponentInChildren<SpriteRenderer> ();
		renderer.sortingOrder = 1;
		renderer.sortingLayerName = "Bullet";
		
		rotation = bullet.transform.rotation.eulerAngles.z * Mathf.Deg2Rad;
		velocity = new Vector2((float)Mathf.Cos(rotation), (float)Mathf.Sin(rotation)); 
		bulletCounter++;
		localIndex = bulletCounter;
	}
	
	public void Update(){
		bullet.transform.position += velocity * SPEED * Time.deltaTime;
	}
	
	public Vector2 getPosition(){	
		return bullet.transform.position;
	}
	
	public GameObject getObject(){
		return bullet;
	}

	public int getIndex(){
		return localIndex;
	}

	public int getDamage(){
		return DAMAGE;
	}
	*/
}