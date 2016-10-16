
public class PascalsTri {

	public static void main(String[] args) {
		String triangle = "1 1";
		boolean flag = true;
		System.out.println("                    "+triangle);
		String [] tokens = triangle.split(" ");
		int max = 10;
		int space = max-1;
		while(tokens.length < max){
			int i = 0;
			int sum = 0;
			for(; i < tokens.length; i++){
				if(i + 1 < tokens.length){
					sum = Integer.parseInt(tokens[i]) + Integer.parseInt(tokens[i+1]);
					if(flag){
						triangle = "1";
						flag = false;
					}
					triangle += " "+sum;
				}
			}
			triangle += " 1";
			for(int j = 0; j < space; j++){
				System.out.print(" ");
			}
			System.out.println(triangle);
			tokens = triangle.split(" ");
			triangle = "1";
			space--;
		}

	}

}
