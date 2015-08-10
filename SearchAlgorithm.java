import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int size = sc.nextInt();
		int [] arr1 = new int[size];
		int sk = 14;
		int [] sortAr = new int[size];

		int [] arr2 = new int[size];
		int ssk = 50;
		for(int i = 0; i < size; i++){
			int value = (int)((Math.random() * 99 + 1));
			arr1[i] = value;
			int value2 = (int)((Math.random() * 99 + 1));
			arr2[i] = value2;
		}
		//printArray(arr1);

		int low = 0;
		int high = arr1.length - 1;
		Arrays.sort(arr1);
		
		//printArray(arr1);

		long sartTime = System.currentTimeMillis();
		System.out.println("My Search found Key "+sk+" found at index: "+mySearch(arr1, sk));
		System.out.println("My Search found Key "+ssk+" found at index: "+mySearch(arr2, ssk));
		long edTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time for my search is " + formatter.format((edTime - sartTime) / 1000d) + " seconds\n");	


		long startTime = System.currentTimeMillis();
		System.out.println("\nLinear Search found Key "+sk+" found at index: "+linearSearch(arr1, sk));
		System.out.println("Linear Search found Key "+ssk+" found at index: "+linearSearch(arr2, ssk));
		long endTime = System.currentTimeMillis();
		NumberFormat formatster = new DecimalFormat("#0.00000");
		System.out.print("Execution time for linear search is " + formatster.format((endTime - startTime) / 1000d) + " seconds\n");	


		SearchAlgorithm mbs = new SearchAlgorithm();
		long startTimem = System.currentTimeMillis();
		System.out.println("\nBinary Search found Key "+sk+" found at index: "+mbs.binarySearch(arr1, sk));
		System.out.println("Binary Search found Key "+ssk+" found at index: "+mbs.binarySearch(arr2, ssk));
		long endTimem = System.currentTimeMillis();
		NumberFormat formatterm = new DecimalFormat("#0.00000");
		System.out.print("Execution time for binary search is " + formatterm.format((endTimem - startTimem) / 1000d) + " seconds\n");	

		long startTimer = System.currentTimeMillis();
		int index = recursiveBinarySearch(arr1,0,arr1.length,sk);
		System.out.println("\nFound "+sk+" at "+index+" index");
		index = recursiveBinarySearch(arr1,0,arr1.length,ssk);
		System.out.println("Found "+ssk+" at "+index+" index");
		long endTimer = System.currentTimeMillis();
		NumberFormat formatterr = new DecimalFormat("#0.00000");
		System.out.print("Execution time for binary recursive is " + formatterr.format((endTimer - startTimer) / 1000d) + " seconds\n");	

	}

	public static int [] selectionSort(int [] ar){
		for(int i = 0; i < ar.length - 1; i++){
			int index = i;
			for(int j = i + 1; j < ar.length; j++){
				if(ar[j] < ar[index]){
					index = j;
					int smallNum = ar[index];
					ar[index] = ar[i];
					ar[i] = smallNum;
				}				
			}
		}
		return ar;
	}

//	public static void quickSort(int[] arr, int low, int high) {
//
//		if (arr == null || arr.length == 0)
//			return;
//
//		if (low >= high)
//			return;
//
//		//pick the pivot
//		int middle = (low + (high - low)) / 2;
//		System.out.println(middle);
//		int pivot = arr[middle];
//
//		//make left < pivot and right > pivot
//		int i = low, j = high;
//		while (i <= j) {
//			while (arr[i] < pivot) {
//				i++;
//			}
//
//			while (arr[j] > pivot) {
//				j--;
//			}
//
//			if (i <= j) {
//				int temp = arr[i];
//				arr[i] = arr[j];
//				arr[j] = temp;
//				i++;
//				j--;
//			}
//		}
//
//		//recursively sort two sub parts
//		if (low < j)
//			quickSort(arr, low, j);
//
//		if (high > i)
//			quickSort(arr, i, high);
//	}

	public static void printArray(int[] x) {
		for (int a : x)
			System.out.print(a + " ");
		System.out.println();
	}

	public static int mySearch(int [] ar, int key){
		int size = ar.length - 1;
		int not = -1;
		int low = 0;
		boolean isEven = false;
		//int [] sortAr = new int[size];

		int asize = ar.length - 1;
		int mid = asize/2;
		if(key == mid){
			return mid;
		}
		if(key % 2 == 0){
			isEven = true;
		}
		if(isEven){
			if(key < mid)
				for(int i = 2; i < mid; i++){
					if(ar[i] == key){
						return i;
					}
				}

			else{
				if(key > mid)
					for(int i = mid +1; i <= ar.length; i++){
						if(ar[i] == key){
							return i;
						}
					}
			}
		}

		return not;
	}

	public static int linearSearch(int[] arr, int key){
		//int [] us = selectionSort(arr);
		int size = arr.length;
		for(int i = 0; i< size; i++){
			if(arr[i] == key){
				return i;
			}
		}
		return -1;
	}

	public int binarySearch(int[] a, int key) {

		 int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	    }

	public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

		if (start < end) {
			int mid = start + (end - start) / 2; 
			if (key < sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, start, mid, key);

			} else if (key > sortedArray[mid]) {
				return recursiveBinarySearch(sortedArray, mid+1, end , key);

			} else {
				return mid;  
			}
		}
		return -(start + 1); 
	}


}
