package Activities;

import java.util.Arrays;

public class Activity2 {
public static void main(String[] args) {
	int[] num= {10,77,10,54,-11,10,10};
	System.out.println("original array is " +Arrays.toString(num));
	int searchNum=10;
	int fixedSum=40;
	
	//System.out.println("final result is " + result(num, searchNum, fixedSum));
	System.out.println("final result is " +result(num, searchNum, fixedSum));
}
public static int result(int[] numbers, int searchNum, int fixedSum) {
	int tempSum=0;
	for(int number:numbers) {
		if(number==searchNum) {
			tempSum=tempSum+searchNum;
		}
		if(tempSum>fixedSum) {
			break;
		}
		
	}
	return tempSum;
}

}
