import java.util.Arrays;

public class LeftArrayShifter {
	private static int [] ShiftLeft(int [] arr)
	{
		int [] newArr = new int [arr.length - 2];
		for(int i = 2; i < arr.length; i++)
		{
			newArr[i - 2] = arr[i];
		}
		return newArr;
	}

	public static void main(String[] args) {
		int [] blah = new int[100];
		for(int i = 0; i < blah.length; i++)
		{
			blah[i] = (int)(Math.random() * blah.length + 1);
		}

		System.out.println(Arrays.toString(blah));
		System.out.println(Arrays.toString(ShiftLeft(blah)));
	}

}
