/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/17/2013
 */

package umc.csgo.utils;

// Imports

import java.io.*;

import umc.csgo.assets.Map;

public class MapWriter {
	
	private static ObjectOutputStream output;
	
	// Open the file given by mapName
	// Make sure it's in the right directory!
	public static void openMap(String mapName) throws IOException {
		try {
			
			/*
			 * TODO: MULTILINE-MISSING
			 */
			//File fMap = new File("bin/maps/"+mapName);
			output = new ObjectOutputStream(
					new FileOutputStream(new File("bin/maps/"+mapName+".map"))
					);
			
		} catch(IOException e) {
			System.err.println("Error: Unable to open map file.");
			throw e;
		}
	}
	
	// Take the map's data and write it, using object serialization, to the file
	public static void addMapData(Map map) throws IOException {
		try {
			
			/* TODO: MISSING */
			output.writeObject(map);
			
		} catch(IOException e) {
			System.err.println("Error: Unable to write map to file.");
			throw e;
		}
	}
	
	// Close the output stream when you are done using it
	public static void closeFile() {
		
		/*
		 * TODO: MULTILINE-MISSING
		 */
		try{
			if(output != null){
				output.close();
			}
		}
		catch(IOException e){
			System.err.println("Error: object output stream could not be closed");
			System.exit(1);
		}
		
	}

}
