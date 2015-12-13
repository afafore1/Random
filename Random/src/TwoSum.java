import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int [] nums = new int [100];
		for(int i = 0; i < nums.length; i++){
			nums[i] = (int)(Math.random() * 200 +1);
		}
		HashMap<Integer, Integer> sums = new HashMap<>();
		int find = 120;
		for(int i = 0; i < nums.length; i++){
			if(sums.containsKey(nums[i])){
				System.out.println(sums.get(nums[i])+","+nums[i]+";");
			}else{
				sums.put(find - nums[i], nums[i]);
			}
		}
	}

}
