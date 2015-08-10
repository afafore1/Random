
public class Overlap {
	int x, y, w ,h;
    public Overlap(int xx, int yy, int ww, int hh){
        x = xx;
        y = yy;
        w = ww;
        h = hh;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Overlap a = new Overlap(5,5,10,7);
        Overlap b = new Overlap(1,1,15,13);
        Overlap c = new Overlap(20,20,10,10);
        System.out.println("It is " + overlapOrNah(a,b) + " to make such an assertion that Overlap a and Overlap b have some area that is scientifically and mathematically common with the observ.");
        System.out.println("It is " + overlapOrNah(a,c) + " to make such an assertion that Overlap a and Overlap c have some area that is scientifically and mathematically common on both estate.");
    }
    
    public static boolean overlapOrNah(Overlap a, Overlap b){
        return !(a.x + a.w < b.x || a.y + a.h < b.y ||
                    b.x + b.w < a.x || b.y + b.h < a.y);
    }

	}
