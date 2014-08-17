/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/20/13
 * 
 * Filename.extention
 * 	Description:
 * 
 */

// Declare the package the file exists in
package umc.csgo.actor;

//Import any classes needed from outside this package
/*
 * 1. You need the actor and enum packages.
 * How do you access these?
 * import enum, already in actor
 */
/*
 * TODO
 * 1 - MISSING CODE
 * */

import umc.csgo.enums.*;

public class CounterTerrorist extends Player {

	private CTSkin skin;
	
	public CounterTerrorist(int pid, String name) {
		super(pid, name);
	}
	
	public void setSkin(CTSkin skin) { this.skin = skin; }
	public void setSkin(int skin) {
		switch(skin) {
		case 2:
			setSkin(CTSkin.GSG9);
			break;
		case 3:
			setSkin(CTSkin.SAS);
			break;
		case 4:
			setSkin(CTSkin.SEAL);
			break;
		case 1:
		default:
			setSkin(CTSkin.GIGN);
		}
	}
	public CTSkin getSkin() { return this.skin; }
	public String getSkinName() { return this.skin.toString(); }

}
