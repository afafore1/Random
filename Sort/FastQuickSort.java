package Sort;

import java.util.Comparator;

public class FastQuickSort {

	public static void qsort(Object [] c, Comparator comparator) {
		// TODO Auto-generated method stub
		int i; 
		int j;
		int left = 0;
		int right = c.length - 1;
		int stack_pointer = -1;
		int [] stack = new int[128];
		Object swap, temp;
		while(true){
			if(right - left <= 7){
				for(j = left + 1; j <= right; j++){
					swap = c[j];
					i = j -1;
					while(i >= left && comparator.compare(c[i], swap) > 0){
						c[i+1] = c[i--];
					}
					c[i+1] = swap;
				}
			}
		}

	}

}
