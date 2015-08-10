import java.util.HashMap;


public class IterateHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> loans = new HashMap<String, String>();
		loans.put("home loan", "citibank");
		loans.put("personal loan", "Wells fargo");
		
		for(String key : loans.keySet()){
			System.out.println("key: " +key +" value: "+loans.get(key));
		}

	}

}
