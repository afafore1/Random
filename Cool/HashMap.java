package Cool;
import java.util.Map;
import java.util.HashMap;
class Dog{
	String color;
	
	Dog(String c){
		color = c;
	}
	public String toString(){
		return color + " dog";
	}
}

public class HashMap {

	public static void main(String[] args) {
		
		HashMap <Dog, Integer> hashMap = new HashMap <Dog, Integer>();
		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
		
		
	}

}
