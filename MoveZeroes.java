import java.util.Arrays;


public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] iArray = new int[] {1,43,6,7,9,0,6,6,7,8,0,8,0,4,0};
//		int i = 0;
//		int j = iArray.length -1;
//		while((i<iArray.length) &&(j>i)){
//			if(iArray[i] == 0){
//				if(iArray[j] != 0){
//					iArray[i] = iArray[i]^iArray[j]; 
//					iArray[j] = iArray[i]^iArray[j];
//					iArray[i] = iArray[i]^iArray[j];
//					i++;
//					j--;
//				}else{
//					j--;
//				}
//			}else{
//				i++;
//		}
//		}
//		System.out.println(Arrays.toString(iArray));

		int rPointer = iArray.length -1;
		for(int lPointer = 0; lPointer < rPointer;lPointer++){
			if(iArray[lPointer] == 0){
				for(int x = lPointer; x < rPointer; x++){
					iArray[x] = iArray[x] ^ iArray[x+1];
					iArray[x+1] = iArray[x] ^ iArray[x+1];
					iArray[x] = iArray[x] ^ iArray[x+1];
				}
				rPointer--;
				lPointer--;
			}
		}
		
		System.out.println(Arrays.toString(iArray));

	}

}
