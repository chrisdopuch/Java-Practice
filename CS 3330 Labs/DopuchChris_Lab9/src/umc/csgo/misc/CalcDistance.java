/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: This class is for calculating the distance between two sets of coordinates. 
 */

//import packages and libraries
package umc.csgo.misc;

import java.lang.Math;

public class CalcDistance {

	public static final double alpha = 5.87;
	
	//default constructor
	CalcDistance(){
	}

	//calculates the distance between either the 2 players or player and bomb's explosion site
	public static double calDistance(double x1, double y1, double x2, double y2){
		double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
		return distance;
	}
}