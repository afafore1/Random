import java.util.LinkedList;


public class Stringmani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] set1 = {"you","we"};
		String [] set2 = {"have","are"};
		String [] set3 = {"sleep","eat","drink"};
		
		LinkedList<String> buffer = new LinkedList<String>();
		makeSen(set1,set2,set3,buffer);
		

	}
	
	public static void makeSen(String [] s1, String [] s2, String [] s3,LinkedList<String> buff){
		if(buff.size() == 3){
			System.out.println(buff);
			buff.clear();
			return;
		}else{
			for(int i = 0; i <s1.length; i++){
				for(int j=0; j<s2.length;j++){
					for(int k = 0; k<s3.length; k++){
						buff.add(s1[i]);
						//buff.append()
					}
				}
			}
		}
	}

}
