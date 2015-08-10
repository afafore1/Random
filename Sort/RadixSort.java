package Sort;

public class RadixSort {
	
	public static void sort( int [] a){
		int i, m = a[0], exp = 1, n = a.length;
		int [] b = new int [10];
		for(i = 1; i < n; i++){
			if(a[i] > m) m = a[i];
			while(m/exp > 0){
				int [] bucket = new int [10];
				for(i = 0; i < n; i++)
					bucket[(a[i] / exp) % 10]++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
