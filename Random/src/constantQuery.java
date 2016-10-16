public class constantQuery {
	static int n = 8;
	static int [][] values = new int[n][n];
	static int [][] sum = new int[n][n];
	public static void update(int x, int y, int val){
		int diff = val - values[x][y];
		for(int i = x; i < sum.length; i++){
			for(int j = y; j < sum.length; j++){
				sum[i][j] += diff;
			}
		}
		values[x][y] = val;
	}
	
	public static int query(int x1, int y1, int x2, int y2){
		return sum[x2][y2];
	}

	public static void main(String[] args) {
		update(0,1,2);
		update(1,1,6);
		
		update(0,7,5);
		update(0,4,20);
		
		System.out.println(query(0,4,1,4));
		for(int i = 0; i < sum.length; i++){
			for(int j = 0; j < sum.length; j++){
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < values.length; i++){
			for(int j = 0; j < values.length; j++){
				System.out.print(values[i][j]+" ");
			}
			System.out.println();
		}	
	}
}
