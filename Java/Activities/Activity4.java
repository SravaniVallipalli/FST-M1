package Activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,6,2,8,10};
		System.out.println("before sort");
		for(int num:arr) {
			System.out.print(num +" ");
		}
		insertionSort(arr);
		
		System.out.println("\nafter sort " +Arrays.toString(arr));
	}
	public static void insertionSort(int[] array) {
		int n=array.length;
		for(int i=1;i<n;i++) {
			int current=array[i];
			int j=i-1;
			while(j>0&&array[j]>current) {
				array[j+1]=array[j];
				j=j-1;
				}
		
			array[j+1]=current;
		}
	}
	


}
