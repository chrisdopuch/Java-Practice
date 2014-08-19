package sorting;

public class HeapSort {

	public HeapSort() {
		
	}
	
	public Integer[] sort ( Integer[] a ) {
		
		buildHeap( a );
		for ( int i = a.length - 1; i >= 1; i-- ) {
			Integer temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			a = heapify( a, 0, i );
		}
		
		return a;
	}
	
	private Integer[] buildHeap( Integer[] a ) {
		
		for ( int i = ( a.length / 2 ) - 1; i >= 0; i-- ) {
			a = heapify( a, i, a.length / 2 );
		}
		
		return a;
	}
	
	private Integer[] heapify ( Integer[] a, int idx, int max ) {
		
		int largest;
		
		int left = 2 * idx + 1;
		int right = 2 * idx + 2;
		
		if ( left < max && a[left] > a[idx] ) {
			largest = left;
		} else {
			largest = idx;
		}
		
		if ( right < max && a[right] > a[largest] ) {
			largest = right;
		}
		if ( largest != idx ) {
			a = heapify( a, largest, max );
		}
		
		return a;
	}
	
}
