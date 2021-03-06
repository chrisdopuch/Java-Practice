package sorting;

import java.util.Random;

public class HeapSortTest {
	public static void main( String[] args ) {

		// create constants
		final int ARRAY_SIZE = 100;
		final int MAX_NUMBER = 100;

		// create the input array to be sorted
		Integer[] inputArray = new Integer[ ARRAY_SIZE];

		try {

			System.out.println( "Unsorted Array: " );

			// create a random number generator and fill the input array with random integers
			Random generator = new Random();
			for ( int i = 0; i < ARRAY_SIZE; i++ ) {
				// assign a new random integer
				inputArray[i] = generator.nextInt( MAX_NUMBER );
				// print out the unsorted array as it is created
				System.out.println( i + ": " + inputArray[i] );
			}
		} catch ( Exception e ) {
			System.out.println("\nCaught exception is: " + e);
		}

		// create new Heap Sort object
		HeapSort sorter = new HeapSort();

		// sort the array
		inputArray = sorter.sort( inputArray );

		// test that the array was correctly sorted
		for ( int i = 0; i < ARRAY_SIZE; i++ ) {
			if ( i > 0 ) {
				if ( inputArray[i] < inputArray[i-1] ) {
					System.out.println( "Error: array was not sorted properly");
					break;
				}
			}
		}

		// print out the array
		for ( int i = 0; i < ARRAY_SIZE; i++ ) {
			System.out.println( i + ": " + inputArray[i] );
		}

	}
}
