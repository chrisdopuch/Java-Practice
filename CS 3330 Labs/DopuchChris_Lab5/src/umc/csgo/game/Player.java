/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;
import umc.csgo.utils.*;

public  abstract class Player extends Actor
implements Moveable{
	
	/* UML
	 * --Class-------------
	 * 
	 *   Player (abstract)
	 * 
	 * --Attributes--------
	 * 
	 * - name:String
	 * - health:int
	 * - isAlive:boolean
	 * - weapon:Weapon
	 * - ammo:Stack
	 * - playerCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Player()
	 * c Player(String)
	 * c Player(String,EWEAPON)
	 * c Player(String,EWEAPON,int,int,Map)
	 * # setName(String):void
	 * + getName():String
	 * # setHealth(int):void
	 * + getHealth():int
	 * # setIsAlive(boolean):void
	 * + getIsAlive():boolean
	 * # setWeapon(Weapon):void
	 * + getWeapon():Weapon
	 * - initAmmo():void
	 * # getAmmo():Stack
	 * + getPlayerCount():int (static)
	 * + printHealth():void
	 * # reload():void
	 * + moveEast(int):boolean
	 * + moveWest(int):boolean
	 * + moveNorth(int):boolean
	 * + moveSouth(int):boolean
	 * + shoot(Player):void
	 * + beingShot(Player,Bullet):void
	 * - die():void
	 * # incPlayerCount():void (static)
	 * # decPlayerCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * + printIntroduction():void
	 * + getLivingCount():int
	 * # incLivingCount():void
	 * # decLivingCount():void
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	Player() & Overloads
	 * 		Default Values:
	 * 			name: "Player"
	 * 			health: 100
	 * 			isAlive: true
	 * 			weapon: KNIFE
	 * 		Initializes all variables for the Player
	 * 		object and increments the number of players
	 * 		and number of living players of either faction
	 * 
	 * 	# setHealth(int):void
	 * 		Sets the health for the player. If the health
	 * 		is below 0, reset to 0 and kill the player off.
	 * 		Remember to reduce the number of players in
	 * 		the game and in that player's faction.
	 * 		Players can only die once.
	 * 
	 * 	+ printHealth():void
	 * 		See sample output
	 * 
	 *	# reload():void
	 *		Reload the clip based on weapon damage and
	 *		weapon clip size
	 * 
	 * 	+ move<N/E/S/W>(int):void
	 * 		See: Moveable
	 * 
	 * 	+ shoot(Player):void
	 * 		Check if the player has ammo and reload if necessary.
	 * 		If there is ammo check if the enemy is alive.
	 * 		If the enemy is alive, check to make sure the enemy
	 * 		isn't the same class as the player (hint: .getClass())
	 * 		If all these conditions are met, roll to see if the
	 * 		player hit or missed based on the accuracy of the gun.
	 * 		For output, see the output provided.
	 * 
	 * 	+ beingShot(Player,Bullet):void
	 * 		Get the distance between the players and the damage
	 * 		of the bullet based on the distance. Print out the
	 * 		damage (see the output provided) and update the player's
	 * 		health. Print the player's health if they are still alive.
	 */
	
	/* Attributes - Instanced */
	
	private String name;
	private int health;
	private boolean isAlive;
	private Weapon weapon;
	private Stack<Bullet> ammo;
	
	
	/* Attributes - Static */
	
	private static int playerCount = 0;
	
	/* Constructors */
	
	public Player(){
		super();
		/*Default Values:
			 * 			name: "Player"
			 * 			health: 100
			 * 			isAlive: true
			 * 			weapon: KNIFE
			 * 		Initializes all variables for the Player
			 * 		object and increments the number of players
			 * 		and number of living players of either faction
			 */
		this.setName("Player");
		this.setHealth(100);
		this.setIsAlive(true);
		this.setWeapon(EWEAPON.KNIFE);
		this.initAmmo();
		Player.incPlayerCount();
	}
	
	public Player(String name){
		super();
		this.setName(name);
		this.setHealth(100);
		this.setIsAlive(true);
		this.setWeapon(EWEAPON.KNIFE);
		this.initAmmo();
		Player.incPlayerCount();
	}
	
	public Player(String name, EWEAPON weapon){
		super();
		this.setName(name);
		this.setHealth(100);
		this.setIsAlive(true);
		this.setWeapon(weapon);
		this.initAmmo();
		Player.incPlayerCount();
	}
	
	public Player(String name, EWEAPON weapon, int x, int y, Map map){
		super(x, y, map);
		this.setName(name);
		this.setHealth(100);
		this.setIsAlive(true);
		this.setWeapon(weapon);
		this.initAmmo();
		Player.incPlayerCount();
	}
	
	/* Getters and Setters - Instanced */
	
	//method to set object's name
	//input string, output void
	protected void setName(String name){
		this.name = name;
	}
	
	//method to get object's name
	//input none, output string
	public String getName(){
		return this.name;
	}

	//method to set object's health
	//input int health points, output void
	protected void setHealth(int healthPoints){
		this.health = healthPoints;
		if( this.health <= 0 && this.getIsAlive()) {
			this.health = 0;
			this.die();
		}
	}
	
	//method to get object's health
	//input none, output int health
	public int getHealth(){
		return this.health;
	}

	//method to set object's alive status
	//input boolean alive, output void
	protected void setIsAlive(boolean alive){
		this.isAlive = alive;
	}

	//method to get if an object is alive
	//input none, output boolean is alive
	public boolean getIsAlive(){
		return this.isAlive;
	}

	//method to set weapon of the object
	//input EWEAPON weapon, output void
	protected void setWeapon(EWEAPON weapon){
		this.weapon = new Weapon(weapon);
	}
	
	//method to get weapon of the object
	//input none, output void
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	//method to initialize ammo
	//input none, output void
	private void initAmmo(){
		this.ammo = new Stack<Bullet>();
	}
	
	//method to return ammo stack of object
	//input none, returns Stack<Bullet> ammo
	 protected Stack<Bullet> getAmmo(){
		return this.ammo;
	}
	 
	 /* print statements */
	 
	 //method to print health, input none, output to console
	 public void printHealth(){
		 if(this.getIsAlive()){
			 System.out.println("Player "+this.getName()+" has "+this.getHealth()+" health.");
		 }
		 else{
			 System.out.println("Player "+this.getName()+" is dead.");
		 }
	 }
	
	
	/* Getters and Setters - Static */
	
	 //method to get the count of players
	public static int getPlayerCount(){
		return Player.playerCount;
	}
	
	
	
	/* Methods - Instanced */
	
	//method to reload the clip
	//input none, output void
	protected void reload(){
		int clipSize = this.getWeapon().getClipSize();
		int i;
		Bullet bullet;
		//add a number of bullets equal to clip size
		for(i=0;i<clipSize;i++){
			//create bullet
			bullet = new Bullet(this.getWeapon().getDamage());
			//add bullet to stack
			this.ammo.push(bullet);
		}
	}
	
	/*the 4 functions for moving in each direction
	 * input: distance moving
	 * output: true if move is possible, false if it's impossible
	 */
	
	public boolean moveEast(int distance){
		if (distance + this.getX() > this.getMap().getHeight()){
			return false;
		}
		else{
			this.setX(distance + this.getX());
			return true;
		}
	}
	
	public boolean moveWest(int distance){
		if (this.getX() - distance < 0){
			return false;
		}
		else{
			this.setX(this.getX() - distance);
			return true;
		}
	}
	
	public boolean moveNorth(int distance){
		if (this.getY() - distance < 0){
			return false;
		}
		else{
			this.setX(this.getY() - distance);
			return true;
		}
	}
	
	public boolean moveSouth(int distance){
		if (distance + this.getY() > this.getMap().getWidth()){
			return false;
		}
		else{
			this.setY(distance + this.getY());
			return true;
		}
	}
	
	//method to shoot a player
	//input Player enemy, output void
	public void shoot(Player enemy){
		//check if ammo is empty
		if(this.getAmmo().size() <= 0){
			this.reload();
			System.out.println(this.getName()+": Reloading!");
		}
		else{
			// check if enemy is alive
			if(!enemy.getIsAlive()){
				System.out.println(this.getName()+": looks like "+enemy.getName()+" is dead!");
				return;
			}
			else{
				//check if it's a team mate
				if(this.getClass() == enemy.getClass()){
					System.out.println(this.getName()+": I almost shot "+enemy.getName()+" by mistake!");
				}
				else{
					//print shooting message
					System.out.println(this.getName()+": I'm shooting at "+enemy.getName()+" with my "+this.getWeapon().getWeapon()+".");
					Random rand = new Random();
					//check to see if they randomly miss
					if(rand.nextInt(100) + 1 > (int)this.getWeapon().getAccuracy()){
						System.out.println(this.getName()+": I missed!");
					}
					else{
						//shoot the enemy
						enemy.beingShot(this, this.getAmmo().pop());
					}
				}
			}
		}
	}
	
	//method to respond to someone shooting at this player
	//input the player who is shooting and a bullet, output void
	public void beingShot(Player shooter, Bullet bullet){
		//get damage and distance
		int damage = bullet.getDamage();
		int distance = LocationUtils.get2dDistance(this.getX(), this.getY(), shooter.getX(), shooter.getY());
		damage = DamageUtils.getDamage(damage, distance);
		//print being shot message to console
		System.out.println(this.getName()+": I was shot by "+shooter.getName()+" for "+damage+" damage from a distance of "+distance+"!");
		//adjust health based on damage
		this.setHealth(this.getHealth() - damage);
		//if the object is still alive, print its health
		if(this.getIsAlive()){
			this.printHealth();
		}
	}
	
	//method to make a player dead
	//input none, output void
	private void die(){
		//make this player not alive
		this.setIsAlive(false);
		//print death rattle
		System.out.println("Player "+this.getName()+" has died.");
		//reduce player count
		Player.decPlayerCount();
		//reduce living count of the subclass
		this.decLivingCount();
	}
	
	
	/* Methods - Static */
	
	//method to increment the number of players
	//input none, output void
	protected static void incPlayerCount(){
		Player.playerCount++;
	}

	//method to decrement the number of players
	//input none, output void
	protected static void decPlayerCount(){
		Player.playerCount--;
	}
	
	/* Methods - Abstract */
	
	
	public abstract void printIntroduction();
	public abstract int getLivingCount();
	protected abstract void incLivingCount();
	protected abstract void decLivingCount();
}
