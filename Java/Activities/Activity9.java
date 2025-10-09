package Activities;

import java.util.ArrayList;

public class Activity9 {
	public static void main(String[] args) {
	ArrayList<String> myList = new ArrayList<String>();
	myList.add("sravani");
	myList.add("vallipalli");
	myList.add("vivek");
	myList.add("geda");
	myList.add("syamala");
	
	for(String list:myList) {
		System.out.println(list);
	}
	System.out.println("3rd element in list is "+ myList.get(2));
	System.out.println("is sravani present in list " +myList.contains("sravani"));
	System.out.println("size of my list is " +myList.size());
	System.out.println("remove geda from list " +myList.remove("geda"));
	System.out.println("size of my list is " +myList.size());
	}
}
