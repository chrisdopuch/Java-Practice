/**
 * This is my attempt at doing a merge sort in Java
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.Scanner;

class MergeSortApp {
	
	private static Scanner input;
	private static int[] data;
	private static int[] helper;

	public static int[] readFile( String fileName )  {

		// Take in an input file and open it for reading
		try {
			input = new Scanner ( new File( fileName ) );
		} catch ( FileNotFoundException e ) {
			System.err.println( "Error opening file." );
			System.exit( 1 );
		}

		int lines = 0;

		try {
			lines = countLines( fileName );
			System.out.println( "Lines: " + lines );
		} catch( IOException e) {
			System.out.println( "Error: " + e );
			System.exit (1 );
		}

		// create the array that will be returned
		int[] intArray = new int[lines];
		int iter = 0;

		while ( input.hasNext( ) ) {
			intArray[iter] = input.nextInt();
			System.out.println ( intArray[iter] );
			iter++;
		}

		return intArray;
	}

	public static int countLines(String fileName) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(fileName));
	    try {
	        byte[] c = new byte[1024];
	        int count = 1;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? -1 : count;
	    } finally {
	        is.close();
	    }
	}

	public static void mergeSort( int low, int high ) {
		//check if it's the base case where size of array equals 1
		if ( ( high - low ) >= 1 ) { //not base case
			int middle1 = ( high + low ) / 2;
			int middle2 = ( middle1 + 1 );
			mergeSort( low, middle1 );
			mergeSort( middle2, high );
			merge( low, middle1, middle2, high );
		}
	}

	public static void merge( int left, int middle1, int middle2, int right ) {
		int leftIndex = left;
		int rightIndex = middle2;
		int combinedIndex = left;
		int[] combined = new int[data.length];

		while ( leftIndex <= middle1 && rightIndex <= right ) {
			if (data[leftIndex] <= data[rightIndex]){
				combined[combinedIndex++] = data[leftIndex++];
			} else {
				combined[combinedIndex++] = data[rightIndex++];
			}
		}

		if (leftIndex == middle2) {
			while (rightIndex <= right ) {
				combined[combinedIndex++] = data[rightIndex++];
			}
		} else {
			while (leftIndex <= middle1 ) {
				combined[combinedIndex++] = data[leftIndex++];
			}
		}

		for (int i = left; i <= right; i++ ) {
			data[i] = combined[i];
		}
	}

	public static void main( String[] args ) {

		// check for right number of arguments
		if ( args.length < 1 ) {
			System.out.println( "USAGE: java MergeSortApp <input.txt>" );
			System.exit( 1 );
		}

		// read the file
		data = readFile( args[0] );

		mergeSort(0, data.length - 1 );

		System.out.println("Sorted Array");
		for (int i : data ) {
			System.out.println( i );
		}

	}

}