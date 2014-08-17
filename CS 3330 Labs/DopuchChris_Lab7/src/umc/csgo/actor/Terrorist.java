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

public class Terrorist extends Player {

	private TSkin skin;
	
	public Terrorist(int pid, String name) {
		super(pid, name);
	}
	
	public void setSkin(TSkin skin) { this.skin = skin; }
	public void setSkin(int skin) {
		switch(skin) {
		case 2:
			setSkin(TSkin.GUERRILLA);
			break;
		case 3:
			setSkin(TSkin.LEET);
			break;
		case 4:
			setSkin(TSkin.PHOENIX);
			break;
		case 1:
		default:
			setSkin(TSkin.ARCTIC);
		}
	}
	public TSkin getSkin() { return this.skin; }
	public String getSkinName() { return this.skin.toString(); }

}
