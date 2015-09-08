package Sorts;

 // O(n*log n);

public class HeapSort {

	public static void sort(int[] a) {
		
		buildHeap(a);
		int length = a.length - 1;
		
		while(length > 0) {
			
			int t = a[0];
			a[0] = a[length];
			a[length] = t;
			
			heapify(a, length, 0);
			length --;
		}
	}
	
	private static void buildHeap(int[] a) {
		
		for(int i = a.length / 2; i >= 0; i --) {
			
			heapify(a, a.length, i);
		}
	}
	
	private static void heapify(int[] a, int length, int i) {
		
		int l = left(i);
		int r = right(i);
		int largest = i;
		
		if(l < length && a[i] < a[l]) {
			
			largest = l;
		}
		
		if(r < length && a[largest] < a[r]) {
			
			largest = r;
		}
		
		if(i != largest) {
			
			int t = a[i];
			a[i] = a[largest];
			a[largest] = t;
			
			heapify(a, length, largest);
		}
	}
	
	private static int left(int i) {
		
		return 2 * i + 2;
	}
	
	private static int right(int i) {
		
		return 2 * i + 1;
	}
}
