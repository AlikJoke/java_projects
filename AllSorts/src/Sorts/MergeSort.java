package Sorts;

public class MergeSort {

	public void sort(int[] a, int low, int high) {
		
        if (low + 1 < high) {
        	
            int mid = (low + high) >>> 1;
            
            sort(a, low, mid);
            sort(a, mid, high);
 
            int size = high - low;
            
            int[] b = new int[size];
            int i = low;
            int j = mid;
            
            for (int k = 0; k < size; k++) {
            	
                if (j >= high || i < mid && a[i] < a[j]) {
                	
                    b[k] = a[i ++];
                } else {
                	
                    b[k] = a[j ++];
                }
            }
            System.arraycopy(b, 0, a, low, size); // O(n*log n);
            //System.out.println(Arrays.toString(b));
        } 
    }
}
