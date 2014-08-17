/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */

public class Weapon extends Item{
	
	/* UML
	 * --Class-------------
	 * 
	 *   Weapon
	 * 
	 * --Attributes--------
	 * 
	 * - weapon:EWEAPON
	 * - weaponCount:int (static)
	 * 
	 * --Methods-----------
	 * 
	 * c Weapon()
	 * c Weapon(EWEAPON)
	 * c Weapon(int,int)
	 * c Weapon(EWEAPON,int,int)
	 * - setWeapon(EWEAPON):void
	 * + getWeapon():EWEAPON
	 * + getWeaponCount():int (static)
	 * + getDamage():int
	 * + getClipSize():int
	 * + getAccuracy():double
	 * + toString():String (overload)
	 * - incWeaponCount():void (static)
	 * - decWeaponCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Hint: Remember to call the super constructor
	 * and to increase the number of items
	 */
	
	/* Attributes - Instanced */
	
	private EWEAPON weapon;
	
	/* Attributes - Static */
	
	private static int weaponCount;
	
	/* Constructors */
	
	public Weapon(){
		super();
		this.setWeapon(EWEAPON.KNIFE);
		Weapon.incWeaponCount();
	}
	
	public Weapon(EWEAPON weapon){
		super();
		this.setWeapon(weapon);
		Weapon.incWeaponCount();
	}
	
	public Weapon(int x, int y){
		super(x, y);
		this.setWeapon(EWEAPON.KNIFE);
		Weapon.incWeaponCount();
	}
	
	public Weapon(EWEAPON weapon, int x, int y){
		super(x, y);
		this.setWeapon(weapon);
		Weapon.incWeaponCount();
	}
	
	/* Getters and Setters - Instanced */
	
	//method to set the EWAEAPON weapon of this object
	//input EWEAPON, output void
	private void setWeapon(EWEAPON weapon){
		this.weapon = weapon;
	}
	
	//method to get this object's weapon
	//input none, returns EWEAPON
	public EWEAPON getWeapon(){
		return this.weapon;
	}
	
	//method to get weapon's damage
	//input none, output void
	public int getDamage(){
		return this.weapon.getDamage();
	}
	
	//method to get weapon's clip size
	//input none, output void
	public int getClipSize(){
		return this.weapon.getClipSize();
	}
	
	//method to get weapon's clip size
	//input none, output void
	public double getAccuracy(){
		return this.weapon.getAccuracy();
	}	
	
	/* Getters and Setters - Static */
	
	//method to get the static weapon count from the class
	//input none, output int
	public static int getWeaponCount(){
		return Weapon.weaponCount;
	}
	
	/* Methods - Instanced */
	
	//override to the toString method
	@Override
	public String toString() {
		return this.getWeapon().toString();
	}
	
	/* Methods - Static */
	
	//method to increase the static weapon count by 1
	//input none, returns void
	private static void incWeaponCount(){
		Weapon.weaponCount++;
	}
	
	//method to dencrease the static weapon count by 1
	//input none, returns void
	private static void decWeaponCount(){
		Weapon.weaponCount--;
	}
	
	/* Methods - Abstract */

}
