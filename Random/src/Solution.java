import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	public static HashSet findLeak(int [] a, int [] b)
	{
		HashMap<Integer, Integer> counter = new HashMap<>();
		for(int i = 0; i < a.length; i++)
		{
			if(counter.containsKey(a[i]))
			{
				counter.put(a[i], counter.get(a[i])+1);
			}else
			{
				counter.put(a[i], 1);
			}
		}
		
		for(int i = 0; i < b.length; i++)
		{
			if(counter.containsKey(b[i]))
			{
				counter.put(b[i], counter.get(b[i])+1);
			}else
			{
				counter.put(b[i], 1);
			}
		}
		HashSet<Integer> leak = new HashSet<>();
		for(int i = 0; i < a.length; i++)
		{
			if(counter.get(a[i]) % 2 != 0)
			{
				leak.add(a[i]);
			}
		}
		return leak;
	}
	public static void main(String[] args) {
		int [] A = {203, 204, 205, 206, 207, 208, 203 ,204 ,205, 206};
		int [] B = {203, 204, 204 ,205, 206, 207, 205, 208, 203, 206 ,205 ,206 ,204};
		System.out.println(findLeak(A, B));
	}

}
