package Activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		hs.add("sravani");
		hs.add("vallipalli");
		hs.add("vivek");
		hs.add("geda");
		hs.add("syamala");
		hs.add("vallipalli");
		System.out.println(hs);
		System.out.println("size of hashset is " +hs.size());
		
		hs.remove("vallipalli");
		System.out.println(hs);
		System.out.println("size of hashset is " +hs.size());
		if(hs.contains("vallipalli")) {
			System.out.println("vallipalli is present in set");
		}
		else {
			System.out.println("vallipalli is not present in set");
		}
		System.out.println(hs);
		System.out.println("size of hashset is " +hs.size());
		
	}

}
