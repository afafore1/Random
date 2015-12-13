import java.util.ArrayList;
import java.util.HashMap;

public class matcher {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		String[] number_one = { "info@fn.ca" , "+122637867"  , "486" , "smbr" , "9946567" };
		String[] number_two = { "+122637867" , "486" , "nrkZone"  , "smbr"};
		ArrayList<String> matched = new ArrayList<>();
		ArrayList<String> unmatched = new ArrayList<>();
		for(int i = 0; i < number_one.length; i++){
			map.put("",number_one[i]);
		}
		for(int i = 0; i< number_two.length; i++){
			if(map.containsKey(number_two[i])){
				map.put("matched", number_two[i]);
			}else if(!map.containsKey(number_two[i])){
				map.put("unmatched", number_two[i] );
			}
		}

		System.out.println(map);
		// {486=matched, nrkZone=unmatched, 9946567=, info@fn.ca=, +122637867=matched, smbr=matched}
		
		for(int i = 0; i < map.size(); i++){
			System.out.println();
			if(map.values().equals("unmatched") || map.values().equals("")){
				unmatched.add(map.get(i));
			}else{
				matched.add(map.get(i));
			}
		}
		System.out.println(matched);
	}

}
