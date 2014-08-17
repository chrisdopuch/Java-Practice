/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/19/2013
 */

// import libraries
import java.util.Random;
import java.util.Stack;

public class Terrorist {
	
	/* UML - Terrorist
	 * --------------------
	 * - codeName: String
	 * - weapon: Weapon
	 * - locationX: int
	 * - locationY: int
	 * - healthPoints: int
	 * - isAlive: boolean
	 * - ammo: Stack<Bullet>
	 * - actorCount: int (static)
	 * - livingTerrorists: int (static)
	 * --------------------
	 * c Terrorist()
	 * c Terrorist(String)
	 * c Terrorist(String,Weapon)
	 * c Terrorist(String,Weapon,int,int)
	 * - setName(String):void
	 * + getName():String
	 * - setHealth(int):void
	 * + getHealth():int
	 * - setAlive(boolean):void
	 * + getAlive():boolean
	 * - setWeapon(Weapon):void
	 * + getWeapon():Weapon
	 * - setLocation(int,int):void
	 * - setX(int):void
	 * - setY(int):void
	 * + getX():int
	 * + getY():int
	 * + getActorCount():int (static)
	 * + getLivingCount():int (static)
	 * + printIntroduction():void
	 * + printHealth():void
	 * + printActorCount():void (static)
	 * + printLivingCount():void (static)
	 * + shoot(Terrorist):void
	 * + beingShot(Terrorist, Bullet):void
	 * - reload():void
	 * - reload(int):void
	 * - die():void
	 * --------------------
	 */

	 /*
	  * Attributes
	  */
	
	// Add the new Attributes from the UML

	private String codeName;
	private Weapon weapon;
	private int locationX;
	private int locationY;
	private int healthPoints;
	private boolean isAlive;
	private Stack<Bullet> ammo;
	private static int actorCount = 0;
	private static int livingTerrorists = 0;

	 /*
	  * Constructor
	  */
	
	public Terrorist() {
		this.setName("Player");
		this.setHealth(100);
		// Default weapon for Terrorists: GLOCK18
		this.setWeapon(Weapon.GLOCK18);
		// Default location: (0,0)
		this.setLocation(0, 0);
		this.setAlive(true);
		ammo = new Stack<Bullet>();
		Terrorist.actorCount++;
		Terrorist.livingTerrorists++;
	}
	
	// Overloaded Constructors - See UML and default Constructor

	public Terrorist(String name) {
		this.setName(name);
		this.setHealth(100);
		// Default weapon for Terrorists: GLOCK18
		this.setWeapon(Weapon.GLOCK18);
		// Default location: (0,0)
		this.setLocation(0, 0);
		this.setAlive(true);
		ammo = new Stack<Bullet>();
		Terrorist.actorCount++;
		Terrorist.livingTerrorists++;
	}
	
	public Terrorist(String name, Weapon weapon) {
		this.setName(name);
		this.setHealth(100);
		this.setWeapon(weapon);
		// Default location: (0,0)
		this.setLocation(0, 0);
		this.setAlive(true);
		ammo = new Stack<Bullet>();
		Terrorist.actorCount++;
		Terrorist.livingTerrorists++;
	}
	
	public Terrorist(String name, Weapon weapon, int x, int y) {
		this.setName(name);
		this.setHealth(100);
		this.setWeapon(weapon);
		this.setLocation(x, y);
		this.setAlive(true);
		ammo = new Stack<Bullet>();
		Terrorist.actorCount++;
		Terrorist.livingTerrorists++;
	}
	
	/*
	 * Getters and Setters
	 */

	private void setName(String codeName) {
		this.codeName = codeName;
	}

	public String getName() {
		return this.codeName;
	}

	/*
	 * SetHealth:
	 * 	Sets player's health to the input value.
	 * 	If the new value is below 0 and the player
	 * 		is alive, reset health to 0, call
	 * 		the player's die method and decrement
	 * 		the livingTerrorist count.
	 */
	private void setHealth(int healthPoints) {
		this.healthPoints = healthPoints;
		if( this.healthPoints <= 0 && this.getAlive()) {
			this.healthPoints = 0;
			this.die();
			Terrorist.livingTerrorists--;
		}
	}

	public int getHealth() {
		return this.healthPoints;
	}
	
	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean getAlive() {
		return this.isAlive;
	}
	
	// Set Weapon
	//input weapon, sets the weapon of this object
	private void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
	// Get Weapon
	//input none, returns the weapon of this object
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	// Set Location
	//input x and y coordinates, sets location of this object
	private void setLocation(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	// Set X - Constrain between 0 and 10
	//input x position, sets x location
	private void setX(int x){
		if(x < 0){
			this.locationX = 0;
		}
		else if(x > 10){
			this.locationX = 10;
		}
		else{
			this.locationX = x;
		}
	}
	
	// Set Y - Constrain between 0 and 10
	//input y position, sets y location
	private void setY(int y){
		if(y < 0){
			this.locationY = 0;
		}
		else if(y > 10){
			this.locationY = 10;
		}
		else{
			this.locationY = y;
		}
	}
		
	// Get X
	//input none, returns this object's x position
	public int getX(){
		return this.locationX;
	}
	
	// Get Y
	//input none, returns this object's y position
	public int getY(){
		return this.locationY;
	}
	
	public static int getActorCount() {
		return Terrorist.actorCount;
	}
	
	public static int getLivingCount() {
		return Terrorist.livingTerrorists;
	}

	/*
	 * Print Methods
	 */
	
	public void printIntroduction() {
		System.out.println("Terrorist "+this.getName()+" has been created.");
	}

	/*
	 * PrintHealth:
	 * 	Checks if a player is alive. If they are, it prints
	 * 		their health, otherwise it prints that they
	 * 		are dead
	 */
	public void printHealth() {
		// Updated
		// Check output for what to display here
		if(this.getAlive()){
			System.out.println("Terrorist "+this.getName()+" has "+this.getHealth()+" health.");
		}
	}

	public static void printActorCount() {
		System.out.println("There are "+Terrorist.actorCount+" Terrorists in the game.");
	}

	public static void printLivingCount() {
		System.out.println("There are "+Terrorist.livingTerrorists+" Terrorists still alive.");
	}

	/*
	 * Other Methods
	 */
	
	/* Shoot:
	 * 	This method checks for ammo and reloads if necessary
	 * 	If there is ammo, and the enemy is alive, the player
	 * 		will announce their intentions for shooting the
	 * 		enemy and call the enemy's beingShot function
	 */
	public void shoot(CounterTerrorist enemy) {
		// If ammo is empty, then reload.
		if(ammo.empty()){
			this.reload();
		}
		// Else
		else{
			// If the enemy is alive, shoot them
			if(enemy.getAlive()){
				System.out.println(this.getName()+": I'm shooting at Counter Terrorist "+enemy.getName()+" with  my "+this.getWeapon()+".");
				enemy.beingShot(this, ammo.pop());
			}
			// Otherwise, well, they're dead
			else{
				System.out.println(this.getName()+": I was going to shoot at Counter Terrorist "+enemy.getName()+" but they're already dead!");
			}
		}
	}
	
	/*
	 * BeingShot:
	 * 	This method calculates the damage taken based on the
	 * 		enemy's bullet and their location
	 * 	It then updates the player's health and reports the
	 * 		new health status
	 */
	public void beingShot(CounterTerrorist enemy, Bullet b) {
		// Calculate the damage based on the bullet and the distance the player was shot from
		// Hint: SharedMethods has static methods that are public that should do these calculations
		int damage = SharedMethods.getDamage(b.getDamage(), SharedMethods.get2dDistance(this.getX(), this.getY(), enemy.getX(), enemy.getY()));
		// Print out update - Check output for what to display here
		System.out.println(this.getName()+": I was shot by Counter Terrorist "+enemy.getName()+" for "+damage+" damage from a distance of "+SharedMethods.get2dDistance(this.getX(), this.getY(), enemy.getX(), enemy.getY())+"!");
		// Update health
		this.setHealth(this.getHealth() - damage);
		// If the player is still alive, print updated health
		if(this.getAlive()) this.printHealth();
	}
	
	/*
	 * Reload Methods: READ THESE TO KNOW WHAT THEY DO
	 */

	/*
	 * Reload:
	 * 	This method has a 10% chance of loading the ammo
	 * 		clip with a full 6 bullets, otherwise the
	 * 		player only loads between 1 and 5 bullets.
	 */
	private void reload() {
		System.out.println(this.getName()+": Reloading!");
		Random rand = new Random();
		// 10% chance at a perfect reload
		int perfectReload = rand.nextInt(100)+1;
		
		if( perfectReload >= 90 ){
			// Perfect reload, give them a full clip
			System.out.println(this.getName()+": Clip is full!");
			this.reload(6);
		} else {
			// Otherwise you get a randomly filled clip
			this.reload(rand.nextInt(5)+1);
		}
	}
	
	/*
	 * Reload (overloaded):
	 * 	Creates ammoCount bullets based on the player's
	 * 		weapon and adds them to the ammo clip
	 */
	private void reload(int ammoCount) {
		// Add ammoCount bullets to ammo
		Bullet bullet;
		for( int i = 0 ; i < ammoCount ; i++ ) {
			// Create a new Bullet based on the player's Weapon
			// and add it to ammo
			bullet = new Bullet(this.getWeapon());
			this.ammo.push(bullet);
			// Hint: Check Bullet's new constructor
		}
	}


	private void die() {
		System.out.println("Terrorist "+ this.getName()+" has died.");
		this.setAlive(false);
	}

}
