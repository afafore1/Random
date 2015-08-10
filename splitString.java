import java.util.StringTokenizer;


public class splitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names = "ayomitunde:fafore:mayowa";
		String [] splits = names.split(":");
		for(String name: splits){
			System.out.println(name);
		}
		StringTokenizer str = new StringTokenizer(names, ":");
		while(str.hasMoreElements()){
			System.out.println(str.nextToken());
		}

	}

}
