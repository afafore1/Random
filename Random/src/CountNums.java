import java.util.HashMap;

public class CountNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 200;
		HashMap<Integer, Integer> counter = new HashMap<>();
		for(int i = 0;i < max; i++){
			int value = (int) (Math.random() * 51);
			if(counter.containsKey(value)){
				counter.put(value, counter.get(value)+1);
			}else{
				counter.put(value, 1);
			}
		}
		System.out.println(counter);
		String query = "I,what, i ";
		query = query.trim();
		String[] tokens = query.split(",");
		String sec = tokens[2];
		String w = String.valueOf(sec.charAt(sec.length()-1));
		if(query.indexOf(w) +1 != query.length()){			
			System.out.println(w);
			System.out.println(query.indexOf(w));
			System.out.println(query.length());
			System.out.println("hey");
		}

	}

}
