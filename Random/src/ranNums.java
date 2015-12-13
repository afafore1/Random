import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ranNums {
	static HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
	
	public static HashSet<Integer> getCons(int source){
		return nodes.get(source);
	}
	public static void main(String[] args) {
		String result = "";
		int max = 100;
		for(int i = 0;i < max; i++){
			HashSet<Integer> st = new HashSet<Integer>();
			while(st.size() < (int)(Math.random() * 4)){
				int con = (int) (Math.random() * max);
				if(con != i) st.add(con);
			}
			nodes.put(i, st);			
		}
		
		for(int i = 0; i < nodes.size(); i++){
			Iterator<Integer> t = getCons(i).iterator();
			while(t.hasNext()){
				int nextNum = t.next();
				if(nodes.get(nextNum) != null){
					if(!(nodes.get(nextNum).contains(i))){
						HashSet<Integer> tList = nodes.get(nextNum);
						tList.add(i);
						nodes.put(nextNum, tList);
					}
				}
				
			}
		}

		for(int i = 0; i< nodes.size(); i++){
			int x = (int) (Math.random() * 1850+ 10);
			int y = (int) (Math.random() * 650 + 10);
			result += i+","+x+","+y+","+nodes.get(i).toString().replace("[", "").replace("]", "").replaceAll(" ", "") +"\n";
		}
		System.out.println(result);

	}

}
