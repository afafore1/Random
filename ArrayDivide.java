
public class ArrayDivide {
	
	public static int getArraySum(int [] arr){
		int sum = 0;
		int len = arr.length;
		for(int i =0; i< len; ++i){
			sum +=arr[i];
		}
		return sum;
	}
	
	public static boolean canDivide(int[] arr){
		int arrSum = getArraySum(arr);
		if(arrSum % 2 != 0){
			return false;
		}
		int size = arr.length;
		int halfsum = arrSum/2;
		boolean [][] SubsetMap = new boolean[halfsum+1][size+1];
		for(int i = 0; i < size + 1; ++i){
			SubsetMap[0][i] = true;
		}
		for(int i = 1; i < halfsum + 1; ++i){
			SubsetMap[i][0] = false;
		}
		for(int i = 0; i < halfsum; ++i){
			for(int j = 1; j < size; ++j){
				SubsetMap[i][j] = SubsetMap[i][j-1] || SubsetMap[i-arr[j-1]][j-1];
			}
			SubsetMap[0][i] = true;
		}
		return SubsetMap[halfsum][size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int []{4,3,2,5,6,7,6,53,4,5,6,3,3,5,6,6,4,4,33,45,66,4};
		System.out.println(canDivide(arr));

	}

}
