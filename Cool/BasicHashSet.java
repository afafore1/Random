package Cool;

import java.util.HashSet;
import java.util.Iterator;

public class BasicHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet <String> h = new HashSet<String>();
		h.add("first");
		h.add("Second");
		h.add("third");
		System.out.println(h);
		System.out.println("check if it's empty "+h.isEmpty());
		h.remove("third");
		System.out.println(h);
		System.out.println("Size "+h.size());
		System.out.println("contains first element? "+h.contains("first"));
		
		
		System.out.println("-------------------------------------------------");
		System.out.println("ITERATING THROUGH HASHSET");
		System.out.println("-------------------------------------------------");
		System.out.println();
		Iterator<String> itr = h.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println("-------------------------------------------------");
		System.out.println("COPY HASHSET");
		System.out.println("-------------------------------------------------");
		System.out.println();
		HashSet<String> sh = new HashSet<String>();
		sh.add("what");
		h.addAll(sh);
		System.out.println(h);

	}

}
