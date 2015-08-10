import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class MoreAnagram {
	
	public static ArrayList<ArrayList<String>> anagrams(String[] strins){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(strins == null || strins.length == 0){
			return result;
		}
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); // create hashmap of strings and Arraylist
		for(int i = 0; i < strins.length; i++){
			char [] temp = strins[i].toCharArray(); 
			Arrays.sort(temp);
			String sorted = new String(temp);
			if(map.containsKey(sorted)){
				map.get(sorted).add(strins[i]);
			}else{
				ArrayList<String> entry = new ArrayList<String>();
				entry.add(strins[i]);
				map.put(sorted, entry);
			}
		}
		Iterator<ArrayList<String>> itr = map.values().iterator();
		while(itr.hasNext()){
			ArrayList<String> item = itr.next();
			result.add(item);
		}
		return result;
	}

	public static void main(String[] args) {
		String [] list = new String []{"acre","race","care","usb","bsu","oiuy","yiou"};		
		System.out.println(anagrams(list));
		

	}

}
