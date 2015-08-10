import java.util.Arrays;
import java.util.Collections;


public class sortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names = {"Ayo", "shade", "mayyour", "steph", "Tunde"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names));

	}

}
