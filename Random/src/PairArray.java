import java.util.HashMap;

public class PairArray {
	
	public static void findPair(int [] arr, int target){
		HashMap<Integer, Integer> pairs = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if(pairs.containsKey(arr[i])){
				System.out.println(arr[i] +" + "+pairs.get(arr[i]));
			}else{
				pairs.put(target - arr[i], arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		int target = 100;
		int [] arr = new int [10000000];
		for(int i = 0; i < arr.length;i++){
			arr[i] = (int)(Math.random() * 100);
		}
		findPair(arr, target);
	}

}
