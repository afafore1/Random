package Sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int [] arr){
		int out;
		int in;
		for(out = arr.length -1; out > 0; out--){
			for(in = 0; in < out; in++){
				if(arr[in] > arr[in + 1]){
					swap(arr, in, in+1);
				}
			}
		}
	}
	
	private static void swap(int [] arr, int first, int second){
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {3,4,5,32,4,53,2,5,6,32,55,8};
		for(int i : arr){
			System.out.print(i);
		}
		System.out.println();
		bubbleSort(arr);
		//Arrays.toString(arr);
		for(int i : arr){
			System.out.print(i);
		}

	}

}
