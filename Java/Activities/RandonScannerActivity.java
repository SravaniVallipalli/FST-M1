package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandonScannerActivity {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		Random indexGen=new Random();
		System.out.println("enter integer values : ");
		System.out.println("(terminate non integer values) :");
		while(scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		Integer nums[]=list.toArray(new Integer[0]);
		int index=indexGen.nextInt(nums.length);
		System.out.println("index value generated is " +index);
		System.out.println("values at the index are " +nums[index]);
		scan.close();
	}

}
