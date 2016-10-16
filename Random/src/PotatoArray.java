import java.util.Arrays;

public class PotatoArray {
	public static void main(String[] args) {
		int maxValue = ~((-1) >>> 1); // Smallest number possible for int.
		int[] originalArray = {16, 18, 0, 8, 17, 6, 5, 5, 9, 13, 10, 16, 18, 2, 1, 6, 13, 12, 13, 13};
		for (int i = 0; i < originalArray.length; i++) {
			if (maxValue < originalArray[i]) maxValue = originalArray[i];
		}
		boolean[] existedOrNaw = new boolean[maxValue + 1];
		int realSize = 0;
		for (int i = 0; i < originalArray.length; i++) {
			if (!existedOrNaw[originalArray[i]]) {
				realSize++;
				existedOrNaw[originalArray[i]] = true;
			}
		}
		int[] resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure = new int[realSize];
		int j = 0;
		existedOrNaw = new boolean[maxValue + 1];
		for (int i = 0; i < originalArray.length; i++) {
			if (!existedOrNaw[originalArray[i]]) {
				resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure[j++] = originalArray[i];
				existedOrNaw[originalArray[i]] = true;
			}
		} 
		System.out.println("Original: " + Arrays.toString(originalArray));
		System.out.println("Potato : " + Arrays.toString(resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure));
	}
}