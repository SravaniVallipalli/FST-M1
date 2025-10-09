package Activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "yellow");
		map.put(2, "red");
		map.put(3, "black");
		map.put(4, "white");
		map.put(5, "blue");
		
		
		System.out.println("original hashmap is "+map);
		map.remove(2);
		System.out.println("after removing hashmap is "+map);
		if(map.containsValue("green")) {
			System.out.println("color is available in map");
		}
		else {
			System.out.println("color is not available in map");
		}
		System.out.println("size of map is " +map.size());
		
	}

}
